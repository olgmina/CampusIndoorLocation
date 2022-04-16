package com.example.visitor.service;

import com.example.visitor.domain.Message;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MessServiceImpl implements MessService{
    private final KafkaTemplate<Long, Message> kafkaMessageTemplate;
    private final ObjectMapper objectMapper;

    @Autowired
    public MessServiceImpl(KafkaTemplate<Long, Message> kafkaMessageTemplate,
                               ObjectMapper objectMapper) {
        this.kafkaMessageTemplate = kafkaMessageTemplate;
        this.objectMapper = objectMapper;
    }

    @Override
    public Message save(Message message) {
        return null;
    }

    @Override
    public void send(Message message) {
        log.info("<= sending {}", writeValueAsString(message));
        kafkaMessageTemplate.send("server.starship", message);
    }

    @Override
    @KafkaListener(id = "Message", topics = {"server.message"}, containerFactory = "singleFactory")
    public void consume(Message message) {
        log.info("=> consumed {}", writeValueAsString(message));
    }


    private String writeValueAsString(Message message) {
        try {
            return objectMapper.writeValueAsString(message);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new RuntimeException("Writing value to JSON failed: " + message.toString());
        }
    }
}
