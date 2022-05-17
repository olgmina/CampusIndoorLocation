package com.example.locationmanager.repository;

import com.example.locationmanager.model.Location;
import org.springframework.data.repository.CrudRepository;

public interface LocationRepository extends CrudRepository<Location, String> {

}
