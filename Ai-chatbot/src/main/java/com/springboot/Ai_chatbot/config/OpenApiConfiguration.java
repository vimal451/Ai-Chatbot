package com.springboot.Ai_chatbot.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class OpenApiConfiguration {

    @Value("${open.api.url}")
    private String apiUrl;


    @Bean
    public RestClient restClient(){
        return RestClient.builder()
                .baseUrl(apiUrl)
                .build();
    }
}
