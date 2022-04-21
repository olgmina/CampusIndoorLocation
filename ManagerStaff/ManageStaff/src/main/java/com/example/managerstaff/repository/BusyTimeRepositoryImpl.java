package com.example.managerstaff.repository;

import com.example.managerstaff.model.BusyTime;
import com.example.managerstaff.model.ManagerStaff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.time.LocalDateTime;

@Component
public class BusyTimeRepositoryImpl {
    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private BusyTimeRepository repository;

    @SuppressWarnings("unused")
    public Iterable<BusyTime> findBusyHoursOfStaff(String staff_id){
        String queryText = "SELECT * FROM busy_time WHERE staff_id = :staff_id";
        Query query = entityManager.createNativeQuery(queryText, BusyTime.class);
        query.setParameter("staff_id", staff_id);
        return query.getResultList();
    }

    @SuppressWarnings("unused")
    public void addSomeStaffs(){

        BusyTime[] busyTimes = {
                new BusyTime(LocalDateTime.parse("2022-04-21T10:15:00"), LocalDateTime.parse("2022-04-21T12:00:00"), "test1"),
                new BusyTime(LocalDateTime.parse("2022-04-21T10:15:00"), LocalDateTime.parse("2022-04-21T12:00:00"), "test2"),
                new BusyTime(LocalDateTime.parse("2022-04-21T14:20:00"), LocalDateTime.parse("2022-04-21T16:00:00"), "test1"),
                new BusyTime(LocalDateTime.parse("2022-04-21T10:15:00"), LocalDateTime.parse("2022-04-21T12:00:00"), "test3"),
                new BusyTime(LocalDateTime.parse("2022-04-21T10:15:00"), LocalDateTime.parse("2022-04-21T12:00:00"), "test4"),
        };

        for (BusyTime busyTime : busyTimes) {
            repository.save(busyTime);
        }
    }
}
