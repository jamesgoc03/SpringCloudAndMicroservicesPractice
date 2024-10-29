package com.james.studentservice.service.feignClient;

import com.james.studentservice.service.http.AddressResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(url = "${address.service.url}", value = "addressFeignClient", path = "/api/address")
//@FeignClient(value = "address-service", path = "/api/address")
@FeignClient(value = "api-gateway")
public interface AddressFeignClient {

    @GetMapping("/address-service/api/address/getById/{id}")
    public AddressResponse getById (@PathVariable long id);

}
