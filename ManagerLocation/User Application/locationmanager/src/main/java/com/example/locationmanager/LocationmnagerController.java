package com.example.locationmanager;

import com.example.locationmanager.error.LocationValidationError;
import com.example.locationmanager.error.LocationValidationErrorBuffer;
import com.example.locationmanager.model.Location;
import com.example.locationmanager.model.Timekeeper;
import com.example.locationmanager.repository.LocationRepository;
import com.example.locationmanager.repository.TimekeeperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("/api")
public class LocationmnagerController {
    private LocationRepository locationRepository;
    private TimekeeperRepository timekeeperRepository;

    @Autowired
    public LocationmnagerController(LocationRepository locationRepository, TimekeeperRepository timekeeperRepository) {
        this.locationRepository = locationRepository;
        this.timekeeperRepository = timekeeperRepository;
    }

    @GetMapping("/locations/getSchedule")
    public ResponseEntity<Iterable<Timekeeper>> getSchedule(){
        return ResponseEntity.ok(timekeeperRepository.findAll());
    }

    @PostMapping("/locations/getFreeLocations")
    public ResponseEntity<Iterable<Timekeeper>> getFreeLocations(
            @Validated @RequestBody Timekeeper timekeeper){
        return ResponseEntity.ok(timekeeperRepository.getFreeLocations(
                timekeeper.getStartDateTime(), timekeeper.getEndDateTime()));
    }

    @GetMapping("/locations")
    public ResponseEntity<Iterable<Location>> getManagerStaff(){
        return ResponseEntity.ok(locationRepository.findAll());
    }

    @GetMapping("/locations/{locationId}")
    public ResponseEntity<Optional<Location>> getStaffByStaffId(@PathVariable String locationId){
        return ResponseEntity.ok(locationRepository.findById(locationId));
    }

    @RequestMapping("/locations/test")
    public void addTestStaff(){
        Location[] locations = {
                new Location(1404, 4, 1, "ул. 20 лет октября", true),
                new Location(1420, 4, 1, "ул. 20 лет октября", false),
                new Location(6345, 3, 6, "ул. 20 лет октября", true)
        };
        ArrayList<Location> saveResults = new ArrayList<>();
        for (Location location : locations) {
            saveResults.add(locationRepository.save(location));
        }

        Timekeeper[] timekeepers = {
                new Timekeeper(LocalDateTime.parse("2022-04-21T10:15:00"), LocalDateTime.parse("2022-04-21T12:00:00"), saveResults.get(0).getId()),
                new Timekeeper(LocalDateTime.parse("2022-04-21T10:15:00"), LocalDateTime.parse("2022-04-21T12:00:00"), saveResults.get(1).getId()),
                new Timekeeper(LocalDateTime.parse("2022-04-21T14:20:00"), LocalDateTime.parse("2022-04-21T16:00:00"), saveResults.get(0).getId()),
                new Timekeeper(LocalDateTime.parse("2022-04-21T08:30:00"), LocalDateTime.parse("2022-04-21T10:05:00"), saveResults.get(2).getId()),
                new Timekeeper(LocalDateTime.parse("2022-04-21T17:50:00"), LocalDateTime.parse("2022-04-21T19:25:00"), saveResults.get(2).getId())
        };
        for (Timekeeper timekeeper : timekeepers) {
            timekeeperRepository.save(timekeeper);
        }
    }

    @PutMapping("/locations/add")
    public ResponseEntity<?> addStaff(@Validated @RequestBody Location location, Errors errors){
        if (errors.hasErrors()) {
            return ResponseEntity.badRequest().
                    body(LocationValidationErrorBuffer.fromBindingErrors(errors));
        }
        Location result = locationRepository.save(location);
        URI locationURI = ServletUriComponentsBuilder.fromCurrentRequest().
                path("/{id}").buildAndExpand(result.getId()).toUri();
        return ResponseEntity.created(locationURI).build();
    }

    @GetMapping("/locations/{locationId}/getStatus")
    public boolean getStaffStatus(@PathVariable String locationId){
        Optional<Location> locationOptional = locationRepository.findById(locationId);
        Location result = locationOptional.get();
        return result.isStatus();
    }

    @RequestMapping("/locations/{locationId}/setStatus")
    public void setStatus(@PathVariable String locationId){
        Optional<Location> locationOptional = locationRepository.findById(locationId);
        if(locationOptional.isPresent()) {
            Location location = locationOptional.get();
            location.setStatus(!location.isStatus());
            locationRepository.deleteById(location.getId());
            locationRepository.save(location);
        }
    }

    @GetMapping("/locations/{locationId}/getTimekeeper")
    public ResponseEntity<Iterable<Timekeeper>> getTimekeeper(@PathVariable String locationId){
        return ResponseEntity.ok(timekeeperRepository.getScheduleByLocationId(locationId));
    }

    @DeleteMapping("/locations/{id}")
    public ResponseEntity<Location> deleteLocation(@PathVariable String id){
        locationRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @ExceptionHandler
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public LocationValidationError handleException(Exception exception) {
        return new LocationValidationError(exception.getMessage());
    }
}
