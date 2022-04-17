package com.example.managerstaff.repository;

import com.example.managerstaff.model.ManagerStaff;
import org.springframework.data.repository.CrudRepository;

public interface ManagerStaffRepository extends CrudRepository<ManagerStaff, String> {
    Iterable<ManagerStaff> findByStaffId(String assertId);
}
