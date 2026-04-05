package com.spring.SpringAi;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ollama")  //name should be according to react(App.jsx file) code
@CrossOrigin("*")
public class OllamaAiController {
    //using chatClient we able to get more options like meta,creating prompt,etc
    private ChatClient chatClient;
    public OllamaAiController(OllamaChatModel chatModel){
        this.chatClient = ChatClient.create(chatModel);
    }
    @GetMapping("/{message}")
    public ResponseEntity<String> getAnswer(@PathVariable String message){
        ChatResponse chatResponse = chatClient
                .prompt(message)
                .call()
                .chatResponse();

        System.out.println(chatResponse.getMetadata().getModel());

        String response=chatResponse.getResult().getOutput().getText();

        return ResponseEntity.ok(response);
    }
}
