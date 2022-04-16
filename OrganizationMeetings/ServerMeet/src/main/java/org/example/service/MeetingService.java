package org.example.service;

import org.example.entity.Meeting;

import java.util.List;
public interface MeetingService {
    List<Meeting> getAllMeeting();
    void saveOrUpdateMeeting(Meeting meeting);
    void deleteMeeting(int id);
    Meeting getMeeting(int id);
}
