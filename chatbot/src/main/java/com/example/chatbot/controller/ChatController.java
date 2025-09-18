package com.example.chatbot.controller;

import com.example.chatbot.model.ChatRequest;
import com.example.chatbot.service.ChatService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/chat")
public class ChatController {

    private final ChatService chatService;

    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    @PostMapping
    public String chat(@RequestBody ChatRequest request) throws Exception {
        return chatService.askQuestion(request.getQuestion());
    }
}
