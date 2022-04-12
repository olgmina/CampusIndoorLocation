package org.example.dao;

import org.example.entity.Meeting;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class ImplDaoMeeting implements DaoMeeting{
    @Autowired
    SessionFactory sessionFactory;

    public ImplDaoMeeting() {
    }

    @Override
    public List<Meeting> getAllMeeting() {
        Session session = sessionFactory.getCurrentSession();
        List<Meeting> meetings =session.createQuery("from Meeting", Meeting.class).getResultList();
        return meetings;
    }

    @Override
    public void saveOrUpdateMeeting(Meeting meeting) {
        Session session = sessionFactory.getCurrentSession();

        session.saveOrUpdate(meeting);
    }

    @Override
    public void deleteMeeting(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query<Meeting> query = session.createQuery("delete from Meeting where id =: meetingId");
        query.setParameter("meetingId", id).executeUpdate();
    }

    @Override
    public Meeting getMeeting(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Meeting.class, id);
    }
}
