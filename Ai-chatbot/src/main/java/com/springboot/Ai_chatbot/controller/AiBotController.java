package com.springboot.Ai_chatbot.controller;


import com.springboot.Ai_chatbot.dto.AiBotPromptRequest;
import com.springboot.Ai_chatbot.service.AiBotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/chat")
@CrossOrigin("*")
public class AiBotController {

    private final AiBotService aiBotService;

    public AiBotController(AiBotService aiBotService){
        this.aiBotService=aiBotService;
    }


    @PostMapping
    public String chat(@RequestBody AiBotPromptRequest promptRequest){
        return aiBotService.getChatResponse(promptRequest);
    }


}
























