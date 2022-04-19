package org.example;

import org.example.dao.Dao;
import org.example.entity.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
public class RestController {
    @Autowired
    Dao<Location> dao;

    @GetMapping("/api/location")
    public List<Location> showLocation(){
        return dao.showLocation();
    }

    @GetMapping("/api/location/{id}")
    public Location getLocation(@PathVariable int id){
        return dao.getLocation(id);
    }

    @DeleteMapping("/api/location/{id}")
    public void deleteLocation(@PathVariable int id){
        dao.deleteLocation(id);
    }

    @PostMapping("")
    public void addLocation(@RequestBody Location location){
        dao.addLocation(location);
    }

}
