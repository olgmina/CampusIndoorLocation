package org.example.dao;

import org.example.entity.Location;

import java.util.List;

public interface Dao<T> {
    List<T> showLocation();
    void addLocation(T t);
    void deleteLocation(int id);
    Location getLocation(int id);
}
