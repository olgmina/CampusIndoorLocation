package com.example.managerstaff.repository;

import com.example.managerstaff.model.BusyTime;
import org.springframework.data.repository.CrudRepository;

public interface BusyTimeRepository extends CrudRepository<BusyTime, String> {
    Iterable<BusyTime> findBusyHoursOfStaff(String assertId);
    void addSomeStaffs();
}
