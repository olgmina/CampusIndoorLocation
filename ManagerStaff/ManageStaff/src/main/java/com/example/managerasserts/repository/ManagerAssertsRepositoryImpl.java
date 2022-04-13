package com.example.managerasserts.repository;

import com.example.managerasserts.model.ManagerStaff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Component
public class ManagerStaffRepositoryImpl {
    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private ManagerStaffRepository repository;

    @SuppressWarnings("unused")
    public Iterable<ManagerStaff> findByAssertId(String assert_id){
        String queryText = "SELECT * FROM managerassert WHERE assert_id = :assert_id";
        Query query = entityManager.createNativeQuery(queryText, ManagerAsserts.class);
        query.setParameter("assert_id", assert_id);
        return query.getResultList();
    }
}
