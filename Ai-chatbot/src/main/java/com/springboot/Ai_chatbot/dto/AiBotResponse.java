package com.springboot.Ai_chatbot.dto;

import org.apache.logging.log4j.message.Message;

import java.util.List;

public record AiBotResponse(List<Choice> choices) {

    public static record Choice(Message message){
        public static record Message(String role,String content){

        }

    }
}
