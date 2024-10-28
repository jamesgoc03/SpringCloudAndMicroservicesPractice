package com.james.addressservice.service;


import com.james.addressservice.Presentation.dto.AddressResponse;
import com.james.addressservice.Presentation.dto.CreateAddressRequest;
import com.james.addressservice.helper.mapper.AddressMapper;
import com.james.addressservice.persistence.model.Address;
import com.james.addressservice.persistence.repository.AddressRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class AddressService {

	@Autowired
	private AddressRepository addressRepository;
	private static final Logger logger = LoggerFactory.getLogger(AddressService.class);

	public AddressResponse createAddress(CreateAddressRequest createAddressRequest) {
		Address address = Address.builder()
				.street(createAddressRequest.getStreet())
				.city(createAddressRequest.getCity())
				.build();
		address = addressRepository.save(address);
		return AddressMapper.mapModelToResponse(address);
	}

	public AddressResponse getById(long id) {
		Optional<Address> address = addressRepository.findById(id);
		if(address.isEmpty())
			throw new NoSuchElementException("The address with id " + id + " does not exist.");
		logger.warn("Hello from this instance");
		return AddressMapper.mapModelToResponse(address.get());
	}

}