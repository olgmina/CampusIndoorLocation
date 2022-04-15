package com.example.managerasserts;

import com.example.managerasserts.error.ManagerStaffValidationError;

import com.example.managerasserts.model.ManagerStaff;
import com.example.managerasserts.repository.ManagerAssertsRepository;
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
public class ManagerStaffController {
    private ManagerStaffRepository repository;

    @Autowired
    public ManagerStaffController(ManagerAssertsRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/managerasserts")
    public ResponseEntity<Iterable<ManagerStaff>> getManagerAsserts(){
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("/managerasserts/{assertId}")
    public ResponseEntity<Iterable<ManagerStaff>> getAssertByAssertId(@PathVariable String assertId){
        return ResponseEntity.ok(repository.findByAssertId(assertId));
    }

    @PutMapping("/managerassert/add")
    public ResponseEntity<?> addAssert(@Validated @RequestBody ManagerStaff managerStaff, Errors errors){
        if (errors.hasErrors()) {
            return ResponseEntity.badRequest().
                    body(ManagerStaffValidationErrorBuffer.fromBindingErrors(errors));
        }
        ManagerStaff result = repository.save(managerStaff);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().
                path("/{id}").buildAndExpand(result.getAssertId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/delete")
    public ResponseEntity<ManagerStaff> deleteStaff(@RequestBody ManagerStaff managerStaff){
        repository.delete(managerStaff);
        return ResponseEntity.noContent().build();
    }

    @ExceptionHandler
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ManagerStaffValidationError handleException(Exception exception) {
        return new ManagerStaffValidationError(exception.getMessage());
    }
}
