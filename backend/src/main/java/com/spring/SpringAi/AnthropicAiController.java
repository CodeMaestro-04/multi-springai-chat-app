package com.spring.SpringAi;

import org.springframework.ai.anthropic.AnthropicChatModel;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/anthropic")  //name should be according to react(App.jsx file) code
@CrossOrigin("*")
public class AnthropicAiController {
//using chatClient we able to get more options like meta,creating prompt,etc
    private ChatClient chatClient;
    public AnthropicAiController(AnthropicChatModel chatModel){
        this.chatClient = ChatClient.create(chatModel);
    }
    @GetMapping("/{message}")
    public ResponseEntity<String> getAnswer(@PathVariable String message){
        String response = chatClient
                .prompt(message)
                .call()
                .content();
        return ResponseEntity.ok(response);
    }
}
