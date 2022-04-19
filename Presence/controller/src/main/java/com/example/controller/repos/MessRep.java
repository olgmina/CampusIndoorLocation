package com.example.controller.repos;

import com.example.controller.domain.Message;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MessRep extends CrudRepository<Message, Integer> {
    List<Message> findByTopicName(String topicName);
}
