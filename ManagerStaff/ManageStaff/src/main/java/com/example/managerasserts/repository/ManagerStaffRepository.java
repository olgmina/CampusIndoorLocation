package com.example.managerasserts.repository;

import com.example.managerasserts.model.ManagerStaff;
import org.springframework.data.repository.CrudRepository;

public interface ManagerAssertsRepository extends CrudRepository<ManagerStaff, String> {
    Iterable<ManagerStaff> findByAssertId(String assertId);
}
