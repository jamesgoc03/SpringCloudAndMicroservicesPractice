package com.james.studentservice.service.http;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class StudentWebClient {

    @Value("${address.service.url}")
    private String addressServiceUrl;

    @Bean
    public WebClient webClient () {
        return WebClient.builder()
                .baseUrl(addressServiceUrl).build();
    }

}
