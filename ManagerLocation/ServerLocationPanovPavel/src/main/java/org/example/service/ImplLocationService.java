package org.example.service;

import org.example.dao.DaoLocation;
import org.example.entity.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
public class ImplLocationService implements LocationService{
    @Autowired
    DaoLocation daoLocation;

    @Override
    @Transactional
    public Location getLocation(int id) {
        return daoLocation.getLocation(id);
    }

    @Override
    @Transactional
    public void deleteLocation(int id) {
        daoLocation.deleteLocation(id);
    }

    @Override
    @Transactional
    public List<Location> showLocation() {
        return daoLocation.showLocation();
    }

    @Override
    @Transactional
    public void addLocation(Location location) {
        daoLocation.addLocation(location);
    }
}
