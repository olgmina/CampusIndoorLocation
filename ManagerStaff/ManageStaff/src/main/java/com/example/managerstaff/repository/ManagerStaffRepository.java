package com.example.managerstaff.repository;

import com.example.managerstaff.model.ManagerStaff;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ManagerStaffRepository extends CrudRepository<ManagerStaff, String> {
    Optional<ManagerStaff> findByStaffId(String assertId);
    void addSomeStaffs();
}
