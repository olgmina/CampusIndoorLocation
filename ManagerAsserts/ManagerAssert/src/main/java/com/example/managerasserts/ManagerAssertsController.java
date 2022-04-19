package com.example.managerasserts;

import com.example.managerasserts.error.ManagerAssertsValidationError;
import com.example.managerasserts.error.ManagerAssertsValidationErrorBuffer;
import com.example.managerasserts.model.ManagerAsserts;
import com.example.managerasserts.model.ManagerAssertsBuilder;
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
public class ManagerAssertsController {
    private ManagerAssertsRepository repository;

    @Autowired
    public ManagerAssertsController(ManagerAssertsRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/managerasserts")
    public ResponseEntity<Iterable<ManagerAsserts>> getManagerAsserts(){
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("/managerasserts/{assertId}")
    public ResponseEntity<Iterable<ManagerAsserts>> getAssertByAssertId(@PathVariable String assertId){
        return ResponseEntity.ok(repository.findByAssertId(assertId));
    }

    @PutMapping("/managerassert/add")
    public ResponseEntity<?> addAssert(@Validated @RequestBody ManagerAsserts managerAsserts, Errors errors){
        if (errors.hasErrors()) {
            return ResponseEntity.badRequest().
                    body(ManagerAssertsValidationErrorBuffer.fromBindingErrors(errors));
        }
        ManagerAsserts result = repository.save(managerAsserts);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().
                path("/{id}").buildAndExpand(result.getAssertId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/delete")
    public ResponseEntity<ManagerAsserts> deleteAsserts(@RequestBody ManagerAsserts managerAsserts){
        repository.delete(managerAsserts);
        return ResponseEntity.noContent().build();
    }
    @DeleteMapping("/delete/{assertId}")
    public ResponseEntity<ManagerAsserts> deleteAssert(@PathVariable String assertId){
        repository.delete(ManagerAssertsBuilder.create().withAssetId(assertId).build());
        return ResponseEntity.noContent().build();
    }

    @ExceptionHandler
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ManagerAssertsValidationError handleException(Exception exception) {
        return new ManagerAssertsValidationError(exception.getMessage());
    }
}
