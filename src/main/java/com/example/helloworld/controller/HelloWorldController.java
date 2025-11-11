package com.example.helloworld.controller;

import com.example.helloworld.service.HelloWorldService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloWorldController {

    private final HelloWorldService service;

    public HelloWorldController(HelloWorldService service) {
        this.service = service;
    }

    @GetMapping("/hello-world")
    public ResponseEntity<?> hello(@RequestParam(name = "name", required = false) String name) {

        //The name greeting evaluation handled in the service layer
        String message = service.evaluateGreeting(name);

        return ResponseEntity.ok(new MessageResponse(message));
    }

    static final class MessageResponse {
        public final String message;

        //Output the message in the response
        MessageResponse(String message) {
            this.message = message;
        }
    }
}
