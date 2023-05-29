package fr.natan.microservicesconfigserver.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetMessageFromConfigServer {
    @Value("${spring.message}")
    private String message;

    @GetMapping("/")
    public String getMessage(){
        return message;
    }
}
