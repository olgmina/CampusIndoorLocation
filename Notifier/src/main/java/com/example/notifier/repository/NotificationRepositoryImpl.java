package com.example.notifier.repository;

import com.example.notifier.model.Notification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Component
public class NotificationRepositoryImpl {
    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private NotificationRepository repository;

    @SuppressWarnings("unused")
    public Iterable<Notification> findByEventId(String event_id){
        String queryText = "SELECT * FROM notification WHERE event_id = :event_id";
        Query query = entityManager.createNativeQuery(queryText, Notification.class);
        query.setParameter("event_id", event_id);
        return query.getResultList();
    }
}
