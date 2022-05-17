package com.example.locationmanager.repository;

import com.example.locationmanager.model.Timekeeper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.time.LocalDateTime;

@Component
public class TimekeeperRepositoryImpl {
    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private TimekeeperRepository repository;

    @SuppressWarnings("unused")
    public Iterable<Timekeeper> getScheduleByLocationId(String locationId) {
        String queryText = "SELECT * FROM Timekeeper WHERE location_id = :location_id";
        Query query = entityManager.createNativeQuery(queryText, Timekeeper.class);
        query.setParameter("location_id", locationId);
        return query.getResultList();
    }

    @SuppressWarnings("unused")
    public Iterable<Timekeeper> getFreeLocations(LocalDateTime startDateTime, LocalDateTime endDateTime) {
        String queryText = "SELECT * FROM Timekeeper " +
                        "WHERE (start_date_time <= :start_time AND end_date_time >= :start_time) " +
                        "OR (start_date_time <= :end_time AND end_date_time >= :end_time) " +
                        "OR (start_date_time >= :start_time AND end_date_time <= :end_time)";
        Query query = entityManager.createNativeQuery(queryText, Timekeeper.class);
        query.setParameter("start_time", startDateTime);
        query.setParameter("end_time", endDateTime);
        return query.getResultList();
    }
}
