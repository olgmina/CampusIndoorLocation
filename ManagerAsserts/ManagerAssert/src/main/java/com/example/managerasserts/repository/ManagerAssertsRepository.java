package com.example.managerasserts.repository;

import com.example.managerasserts.model.ManagerAsserts;
import org.springframework.data.repository.CrudRepository;

public interface ManagerAssertsRepository extends CrudRepository<ManagerAsserts, String> {
    Iterable<ManagerAsserts> findByAssertId(String assertId);
}
