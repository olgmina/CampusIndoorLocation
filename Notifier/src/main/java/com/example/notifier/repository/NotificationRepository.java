package com.example.notifier.repository;

import com.example.notifier.model.Notification;
import org.springframework.data.repository.CrudRepository;

public interface NotificationRepository extends CrudRepository<Notification, String> {
    Iterable<Notification> findByEventId(String eventId);
}
