package com.maximillian.springbootrabbit.publisher;

import com.maximillian.springbootrabbit.dto.User;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RabbitMQJsonProducer {
    @Value("${rabbitmq.routing.json.key}")
    private String jsonRoutingKey;

    @Value("${rabbitmq.exchange.name}")
    private String exchange;

    private final RabbitTemplate rabbitTemplate;

    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMQJsonProducer.class);
    public void sendMessageJson(User user){
        LOGGER.info(String.format("json message sent -> %s", user.toString()));
        rabbitTemplate.convertAndSend(exchange, jsonRoutingKey, user);

    }
}
