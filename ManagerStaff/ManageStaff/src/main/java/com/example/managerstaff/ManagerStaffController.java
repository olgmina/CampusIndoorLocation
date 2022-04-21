package com.example.managerstaff;

import com.example.managerstaff.error.ManagerPersonalValidationErrorBuffer;
import com.example.managerstaff.error.ManagerStaffValidationError;

import com.example.managerstaff.model.BusyTime;
import com.example.managerstaff.model.ManagerStaff;
import com.example.managerstaff.model.ManagerStaffBuilder;
import com.example.managerstaff.repository.BusyTimeRepository;
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
    private ManagerStaffRepository managerStaffRepository;
    private BusyTimeRepository busyTimeRepository;

    @Autowired
    public ManagerStaffController(ManagerStaffRepository managerStaffRepository, BusyTimeRepository busyTimeRepository) {
        this.managerStaffRepository = managerStaffRepository;
        this.busyTimeRepository = busyTimeRepository;
    }

    @GetMapping("/managerstaff/getSchedule")
    public ResponseEntity<Iterable<BusyTime>> getStaffSchedule(){
        return ResponseEntity.ok(busyTimeRepository.findAll());
    }

    @GetMapping("/managerstaff")
    public ResponseEntity<Iterable<ManagerStaff>> getManagerStaff(){
        return ResponseEntity.ok(managerStaffRepository.findAll());
    }

    @GetMapping("/managerstaff/{staffId}")
    public ResponseEntity<Optional<ManagerStaff>> getStaffByStaffId(@PathVariable String staffId){
        return ResponseEntity.ok(managerStaffRepository.findByStaffId(staffId));
    }

    @RequestMapping("/managerstaff/testadd")
    public void addTestStaff(){
        managerStaffRepository.addSomeStaffs();
        busyTimeRepository.addSomeStaffs();
    }

    @PutMapping("/managerstaff/add")
    public ResponseEntity<?> addStaff(@Validated @RequestBody ManagerStaff managerStaff, Errors errors){
        if (errors.hasErrors()) {
            return ResponseEntity.badRequest().
                    body(ManagerPersonalValidationErrorBuffer.fromBindingErrors(errors));
        }
        ManagerStaff result = managerStaffRepository.save(managerStaff);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().
                path("/{id}").buildAndExpand(result.getStaffId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @GetMapping("/managerstaff/{staffId}/getStatus")
    public boolean getStaffStatus(@PathVariable String staffId){
        Optional<ManagerStaff> managerStaff = managerStaffRepository.findByStaffId(staffId);
        ManagerStaff result = managerStaff.get();
        return result.isStatus();
    }

    @RequestMapping("/managerstaff/{staffId}/setStatus")
    public void setStatus(@PathVariable String staffId){
        Optional<ManagerStaff> managerStaff = managerStaffRepository.findByStaffId(staffId);
        if(managerStaff.isPresent()) {
            ManagerStaff staff = managerStaff.get();
            staff.setStatus(false);
            managerStaffRepository.deleteById(staff.getId());
            managerStaffRepository.save(managerStaff.get());
        }
    }

    @RequestMapping("/managerstaff/{staffId}/setLocation")
    public void setLocation(@PathVariable String staffId){
        Optional<ManagerStaff> managerStaff = managerStaffRepository.findByStaffId(staffId);
        if(managerStaff.isPresent()) {
            ManagerStaff staff = managerStaff.get();
            staff.setAudiance(2222);
            staff.setBuilding(2);
            staff.setLocationName("Конференция");
            managerStaffRepository.deleteById(staff.getId());
            managerStaffRepository.save(managerStaff.get());
        }
    }

    @GetMapping("/managerstaff/{staffId}/getBusyHours")
    public ResponseEntity<Iterable<BusyTime>> getHours(@PathVariable String staffId){
        return ResponseEntity.ok(busyTimeRepository.findBusyHoursOfStaff(staffId));
    }

    @DeleteMapping("/managerstaff/{id}")
    public ResponseEntity<ManagerStaff> deleteToDo(@PathVariable String id){
        managerStaffRepository.delete(ManagerStaffBuilder.create().withStaffId(id).build());
        return ResponseEntity.noContent().build();
    }

    @ExceptionHandler
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ManagerStaffValidationError handleException(Exception exception) {
        return new ManagerStaffValidationError(exception.getMessage());
    }
}
