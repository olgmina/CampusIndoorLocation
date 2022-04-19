package org.example.controller;

import org.example.entity.Meeting;
import org.example.kafka.ProducerExample;
import org.example.service.MeetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MyRestController {
    @Autowired
    MeetingService meetingService;

    @GetMapping("/meeting")
    public List<Meeting> showAllMeeting(){
        List<Meeting> meetingsList = meetingService.getAllMeeting();
        return meetingsList;
    }
    @GetMapping("/meeting/{id}")
    public Meeting getMeeting(@PathVariable int id){
        return meetingService.getMeeting(id);
    }
    @PostMapping("/meeting")
    public Meeting addMeeting(@RequestBody Meeting meeting){
        meetingService.saveOrUpdateMeeting(meeting);
        return meeting;
    }

    @DeleteMapping("/meeting/{id}")
    public void deleteMeeting(@PathVariable int id){
        Meeting meeting = meetingService.getMeeting(id);
        ProducerExample.sendMessageKafka(meeting.toString());
        meetingService.deleteMeeting(id);

    }

}
