package org.example;

import org.example.dao.DaoLocation;
import org.example.entity.Location;
import org.example.service.ImplLocationService;
import org.example.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RequestMapping("/")
@org.springframework.web.bind.annotation.RestController
public class RestController {
    @Autowired
    LocationService locationService;

    @GetMapping("/api/location")
    public List<Location> showLocation(){
        return locationService.showLocation();
    }
    @GetMapping("/api/location/{id}")
    public Location getLocation(@PathVariable int id){
        return locationService.getLocation(id);
    }
    @DeleteMapping("/api/location/{id}")
    public void deleteLocation(@PathVariable int id){
        locationService.deleteLocation(id);
    }
    @PostMapping("/api/location")
    public void addLocation(@RequestBody Location location){
        locationService.addLocation(location);
    }

}
