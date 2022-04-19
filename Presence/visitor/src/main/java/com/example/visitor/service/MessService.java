package com.example.visitor.service;

import com.example.visitor.domain.Message;

public interface MessService {
    Message save(Message message);
    void send(Message message);
    void consume(Message message);
}
