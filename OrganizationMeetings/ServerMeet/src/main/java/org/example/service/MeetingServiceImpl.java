package org.example.service;

import org.example.dao.DaoMeeting;
import org.example.entity.Meeting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MeetingServiceImpl implements MeetingService{
    @Autowired
    DaoMeeting daoMeeting;

    public MeetingServiceImpl() {
    }

    @Override
    @Transactional
    public List<Meeting> getAllMeeting() {
        return daoMeeting.getAllMeeting();
    }

    @Override
    @Transactional
    public void saveOrUpdateMeeting(Meeting meeting) {
        daoMeeting.saveOrUpdateMeeting(meeting);
    }

    @Override
    @Transactional
    public void deleteMeeting(int id) {
        daoMeeting.deleteMeeting(id);
    }

    @Override
    @Transactional
    public Meeting getMeeting(int id) {
        return daoMeeting.getMeeting(id);
    }
}
