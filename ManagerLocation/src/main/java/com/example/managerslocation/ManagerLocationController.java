package com.example.managerslocation;

import com.example.managerslocation.error.ManagerLocationValidationError;
import com.example.managerslocation.error.ManagerLocationValidationErrorBuffer;
import com.example.managerslocation.model.ManagerLocation;
import com.example.managerslocation.repository.ManagerLocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@CrossOrigin(origins = "http://127.0.0.1:5500/")
@RestController
@RequestMapping("/api")
public class ManagerLocationController {
    private ManagerLocationRepository repository;

    @Autowired
    public ManagerLocationController(ManagerLocationRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/managerlocation")
    public ResponseEntity<Iterable<ManagerLocation>> getManagerLocation(){
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("/managerlocation/{locationId}")
    public ResponseEntity<Iterable<ManagerLocation>> getLocationByLocationId(@PathVariable String locationId){
        return ResponseEntity.ok(repository.findByLocationId(assertId));
    }

    @PutMapping("/managerlocation/add")
    public ResponseEntity<?> addLocation(@Validated @RequestBody ManagerLocation managerLocation, Errors errors){
        if (errors.hasErrors()) {
            return ResponseEntity.badRequest().
                    body(ManagerLocationValidationErrorBuffer.fromBindingErrors(errors));
        }
        ManagerLocation result = repository.save(managerLocation);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().
                path("/{id}").buildAndExpand(result.getLocationId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/delete")
    public ResponseEntity<ManagerLocation> deleteLocation(@RequestBody ManagerLocation managerLocation){
        repository.delete(managerLocation);
        return ResponseEntity.noContent().build();
    }

    @ExceptionHandler
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ManagerLocationValidationError handleException(Exception exception) {
        return new ManagerLocationValidationError(exception.getMessage());
    }
}
