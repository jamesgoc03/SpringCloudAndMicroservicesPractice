package com.james.addressservice.helper.mapper;

import com.james.addressservice.Presentation.dto.AddressResponse;
import com.james.addressservice.persistence.model.Address;

public class AddressMapper {

    public static AddressResponse mapModelToResponse(Address address) {
        return AddressResponse.builder()
                .id(address.getId())
                .street(address.getStreet())
                .city(address.getCity())
                .build();
    }

}
