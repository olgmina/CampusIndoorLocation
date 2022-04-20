package com.example.managerstaff;

import com.example.managerstaff.error.ManagerStaffValidationError;
import com.example.managerstaff.error.ManagerStaffValidationErrorBuffer;
import com.example.managerstaff.model.ManagerStaff;
import com.example.managerstaff.model.ManagerStaffBuilder;
import com.example.managerstaff.repository.ManagerStaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@CrossOrigin(origins = "http://127.0.0.1:5500/")
@RestController
@RequestMapping("/api")
public class ManagerStaffController {
    private ManagerStaffRepository repository;

    @Autowired
    public ManagerStaffController(ManagerStaffRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/managerstaff")
    public ResponseEntity<Iterable<ManagerStaff>> getManagerStaff(){
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("/managerstaff/{staffId}")
    public ResponseEntity<Iterable<ManagerStaff>> getStaffByStaffId(@PathVariable String staffId){
        return ResponseEntity.ok(repository.findByStaffId(staffId));
    }

    @GetMapping("/managerstaff/{staffId}/getStatus")
    public  boolean getStaffStatus(@PathVariable String id){
        Optional<ManagerStaff> managerStaff = repository.findById(id);
        ManagerStaff result = managerStaff.get();
        return result.isStatus();
    }

    @PutMapping("/managerstaff/add")
    public ResponseEntity<?> addStaff(@Validated @RequestBody ManagerStaff managerStaff, Errors errors){
        if (errors.hasErrors()) {
            return ResponseEntity.badRequest().
                    body(ManagerStaffValidationErrorBuffer.fromBindingErrors(errors));
        }
        ManagerStaff result = repository.save(managerStaff);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().
                path("/{id}").buildAndExpand(result.getStaffId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/delete")
    public ResponseEntity<ManagerStaff> deleteStaff(@RequestBody ManagerStaff managerStaff){
        repository.delete(managerStaff);
        return ResponseEntity.noContent().build();
    }
    @DeleteMapping("/delete/{staffId}")
    public ResponseEntity<ManagerStaff> deleteStaff(@PathVariable String staffId){
        repository.delete(ManagerStaffBuilder.create().withStaffId(staffId).build());
        return ResponseEntity.noContent().build();
    }

    @ExceptionHandler
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ManagerStaffValidationError handleException(Exception exception) {
        return new ManagerStaffValidationError(exception.getMessage());
    }
}
