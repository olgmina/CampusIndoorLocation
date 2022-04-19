package org.example.communicat;


import org.example.entity.Meeting;

import java.util.List;

public interface MeetingCommunicat {
    List<Meeting> listMeeting();
    Meeting getMeeting(int id);
    void addMeeting(Meeting meeting);
    void deleteMeeting(int id);
}
