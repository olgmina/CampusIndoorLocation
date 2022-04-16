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
    public String number;

    @GetMapping("api/presence/send")
    public String presence(Map<String, Object> model) {
        Iterable<Message> messages = messRep.findAll();
        model.put("messages", messages);
        return "presence";
    }


    @PostMapping("api/presence/send")
    public String send(Integer id_event, String topicName, Map<String, Object> model) {
        id_event_rand(id_event);
        topicName_rand(topicName);
        Message message = new Message(id_event, topicName);
        send(message);
        messRep.save(message);
        Iterable<Message> messages = messRep.findAll();
        model.put("messages", messages);
        return "presence";
    }

    public void send(@RequestBody Message message) {
        messService.send(message);
    }

    public Integer id_event_rand(Integer id_event) {
        id_event = random.nextInt(10);
        return id_event;
    }

    public String topicName_rand(String topicName) {
        topicName = "topic" + String.valueOf(random.nextInt(3));
        return topicName;
    }
}
