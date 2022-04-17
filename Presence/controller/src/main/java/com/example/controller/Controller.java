package com.example.controller;

import com.example.controller.domain.Message;
import com.example.controller.repos.MessRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;
import java.util.Random;

@org.springframework.stereotype.Controller
public class Controller {

    final Random random = new Random();
    @Autowired
    private MessRep messRep;

   /* @GetMapping("api/presence/send")
    public String presence(Map<String, Object> model) {
        Iterable<Message> messages = messRep.findAll();
        model.put("messages", messages);
        return "presence";
    }*/

    @GetMapping("api/getNameTopic")
    public String presence(Map<String, Object> model) {
        Iterable<Message> messages = messRep.findAll();
        model.put("messages", messages);
        return "presence";



  /* @PostMapping("api/presence/send")
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
    }*/

   @PostMapping("api/getNameTopic")
    public String filter(@RequestParam String filter, Map<String, Object> model, Integer amount){
        Iterable<Message> messages;
        if (filter != null && !filter.isEmpty()) {
            messages = messRep.findByTopicName(filter);
            amount = ((List<Message>) messages).size();
        } else {
            messages = messRep.findAll();
        }
        model.put("messages", messages);
        return "presence";
    }


  /* public Integer id_event_rand(Integer id_event) {
        id_event = random.nextInt(10);
        return id_event;
    }

    public String topicName_rand(String topicName) {
        topicName = "topic" + String.valueOf(random.nextInt(3));
        return topicName;
    }*/
}
