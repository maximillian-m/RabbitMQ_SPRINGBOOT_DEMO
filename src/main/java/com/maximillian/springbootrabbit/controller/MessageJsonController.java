package com.maximillian.springbootrabbit.controller;

import com.maximillian.springbootrabbit.dto.User;
import com.maximillian.springbootrabbit.publisher.RabbitMQJsonProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class MessageJsonController {
    private final RabbitMQJsonProducer producer;

    @PostMapping("/publish")
    public ResponseEntity<String> sendJsonMessage(@RequestBody User user){
        producer.sendMessageJson(user);
        return ResponseEntity.ok("Json message sent to RabbitMQ");
    }

}
