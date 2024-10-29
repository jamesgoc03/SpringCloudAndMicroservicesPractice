package com.james.studentservice.service.impl;

import com.james.studentservice.service.feignClient.AddressFeignClient;
import com.james.studentservice.service.http.AddressResponse;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommonService {

    Logger logger = LoggerFactory.getLogger(CommonService.class);
    Long count = 1L;

    @Autowired
    AddressFeignClient addressFeignClient;

    @CircuitBreaker(name = "addressService", fallbackMethod = "fallbackGetAddressById")
    public AddressResponse getAddressById (Long addressId) {
        logger.warn("Count: " +  count);
        count++;
        return addressFeignClient.getById(addressId);
    }

    public AddressResponse fallbackGetAddressById (Long addressId, Throwable throwable) {
        logger.error("Error: " + throwable);
        return new AddressResponse();
    }

	/*
	public AddressResponse getAddressById (Long addressId) {
		Mono<AddressResponse> addressResponse =
				webClient.get().uri("/getById/" + addressId)
				.retrieve().bodyToMono(AddressResponse.class);
		return addressResponse.block();
	}
	*/

}
