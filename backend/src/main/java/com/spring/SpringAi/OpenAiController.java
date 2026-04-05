package com.spring.SpringAi;

import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/openai")
@CrossOrigin("*")
public class OpenAiController {

    private OpenAiChatModel chatModel;
    //constructor injection for using openaichatmodel and its the way to connect llm model using chatmodel
    public OpenAiController(OpenAiChatModel chatModel){
        this.chatModel = chatModel;
    }
    @GetMapping("/{message}")
    public ResponseEntity<String> getAnswer(@PathVariable String message){
        String response = chatModel.call(message);
        return ResponseEntity.ok(response);
    }
}
