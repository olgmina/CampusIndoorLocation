package org.example.service;

import org.example.entity.Location;

import java.util.List;

public interface LocationService {
    Location getLocation(int id);
    void deleteLocation(int id);
    List<Location> showLocation();
    void addLocation(Location location);
}
