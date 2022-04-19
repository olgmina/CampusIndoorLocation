package com.example.managerlocation.repository;

import com.example.managerslocation.model.ManagerLocation;
import org.springframework.data.repository.CrudRepository;

public interface ManagerLocationRepository extends CrudRepository<ManagerLocation, String> {
    Iterable<ManagerLocation> findByLocationId(String locationId);
}
