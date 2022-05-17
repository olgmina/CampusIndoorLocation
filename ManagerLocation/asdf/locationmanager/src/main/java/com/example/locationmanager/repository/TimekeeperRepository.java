package com.example.locationmanager.repository;

import com.example.locationmanager.model.Timekeeper;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDateTime;

public interface TimekeeperRepository extends CrudRepository<Timekeeper, String> {
    Iterable<Timekeeper> getScheduleByLocationId(String locationId);
    Iterable<Timekeeper> getFreeLocations(LocalDateTime startDateTime, LocalDateTime endDateTime);
}
