package org.example.dao;

import org.example.entity.Location;

import java.util.List;

public interface DaoLocation {
    List<Location> showLocation();
    void addLocation(Location location);
    void deleteLocation(int id);
    Location getLocation(int id);
}
