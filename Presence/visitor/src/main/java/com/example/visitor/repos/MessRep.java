package com.example.visitor.repos;

import com.example.visitor.domain.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessRep extends CrudRepository<Message, Integer> {
}
