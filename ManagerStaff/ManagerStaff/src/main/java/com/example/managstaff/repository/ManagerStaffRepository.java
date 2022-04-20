package com.example.managstaff.repository;

import com.example.managstaff.model.ManagerStaff;
import org.springframework.data.repository.CrudRepository;

public interface ManagerStaffRepository extends CrudRepository<ManagerStaff, String> {
    Iterable<ManagerStaff> findByStaffId(String staffId);
}
