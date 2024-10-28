package com.james.addressservice.Presentation.controller;

import com.james.addressservice.Presentation.dto.AddressResponse;
import com.james.addressservice.Presentation.dto.CreateAddressRequest;
import com.james.addressservice.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/address")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @PostMapping("/create")
    public AddressResponse createAddress (@RequestBody CreateAddressRequest createAddressRequest) {
        return addressService.createAddress(createAddressRequest);
    }

    @GetMapping("getById/{id}")
    public AddressResponse getById (@PathVariable long id) {
        return addressService.getById(id);
    }

}