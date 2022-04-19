package org.example.dao;

import org.example.entity.Meeting;

import java.util.List;

public interface DaoMeeting {
    List<Meeting> getAllMeeting();
    void saveOrUpdateMeeting(Meeting meeting);
    void deleteMeeting(int id);
    Meeting getMeeting(int id);
}
