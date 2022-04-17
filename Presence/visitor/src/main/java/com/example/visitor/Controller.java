package com.example.visitor;

import com.example.visitor.domain.Message;
import com.example.visitor.repos.MessRep;
import com.example.visitor.service.MessService;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.Map;
import java.util.Random;

@org.springframework.stereotype.Controller
public class Controller {

    private final MessService messService;

    public Controller(MessService messService) {
        this.messService = messService;
    }

    final Random random = new Random();
    @Autowired
    private MessRep messRep;

    @GetMapping("api/presence/send")
    public String presence(Map<String, Object> model) {
        Iterable<Message> messages = messRep.findAll();
        model.put("messages", messages);
        return "presence";
    }


    @PostMapping("api/presence/send")
    public String add(String event, String topicName, String visitor, @RequestParam(name = "comment", required = false) String comment, Map<String, Object> model) {
        int rand = random.nextInt(5);
        event = "event" + String.valueOf(rand);
        topicName = "topic" + String.valueOf(rand);
        visitor = "visitor";
        Message message = new Message(event, topicName, visitor, comment);
        messRep.save(message);
        Iterable<Message> messages = messRep.findAll();
        model.put("messages", messages);
        return "presence";
    }

    @PostMapping("api/presence/send")
    public void send(@RequestBody Message message) {
        messService.send(message);
    }
}
