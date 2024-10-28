package com.james.addressservice.Presentation.dto;

import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateAddressRequest {

    private String street;
    private String city;

}