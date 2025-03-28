package com.springboot.Ai_chatbot.dto;

import org.apache.logging.log4j.message.Message;

import java.util.List;

public record AiBotRequest(String model, List<Message> message) {

    public static record Message(String role,String content){}
}
