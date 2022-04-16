package com.example.controller;

import com.example.controller.domain.Message;
import com.example.controller.repos.MessRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;
import java.util.Random;

@org.springframework.stereotype.Controller
public class Controller {

    final Random random = new Random();
    @Autowired
    private MessRep messRep;
    public String number;

    @GetMapping("api/getNameTopic")
    public String presence(Map<String, Object> model) {
        Iterable<Message> messages = messRep.findAll();
        model.put("messages", messages);
        return "presence";
    }


  /* @PostMapping("api/presence/send")
    public String send(Integer id_event, String topicName, Map<String, Object> model) {
        id_event_rand(id_event);
        topicName_rand(topicName);
        Message message = new Message(id_event, topicName);
        messRep.save(message);
        Iterable<Message> messages = messRep.findAll();
        model.put("messages", messages);
        return "presence";
    }*/

   @PostMapping("api/getNameTopic")
    public String filter(@RequestParam String filter, Map<String, Object> model){
        Iterable<Message> messages;
        if (filter != null && !filter.isEmpty()) {
            messages = messRep.findByTopicName(filter);
        } else {
            messages = messRep.findAll();
        }
        model.put("messages", messages);
        return "presence";
    }


 /*   public Integer id_event_rand(Integer id_event) {
        id_event = random.nextInt(10);
        return id_event;
    }

    public String topicName_rand(String topicName) {
        topicName = "topic" + String.valueOf(random.nextInt(3));
        return topicName;
    }*/
}
