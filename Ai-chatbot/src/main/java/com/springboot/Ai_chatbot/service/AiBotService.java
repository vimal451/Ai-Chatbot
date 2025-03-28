package com.springboot.Ai_chatbot.service;

import com.springboot.Ai_chatbot.dto.AiBotPromptRequest;
import com.springboot.Ai_chatbot.dto.AiBotRequest;
import com.springboot.Ai_chatbot.dto.AiBotResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
public class AiBotService {

    private final RestClient restClient;


    public AiBotService(RestClient restClient){
        this.restClient=restClient;
    }

    @Value("${openapi.api.key}")
    private String apiKey;

    @Value("${openapi.api.model}")
    private String model;

    public String getChatResponse(AiBotPromptRequest promptRequest){

        AiBotRequest aiBotRequest= new AiBotRequest(
                model,
                List.of(new AiBotRequest.Message("user",promptRequest.prompt()))
        );

        AiBotResponse response =restClient.post()
                .header("Authorization","Bearer " + apiKey)
                .header("Content-Type","application/json")
                .body(aiBotRequest)
                .retrieve()
                .body(AiBotResponse.class);
        return response.choices().get(0).message().content();

    }
}















