package com.example.managerlocation.repository;

import com.example.managerslocation.model.ManagerLocation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Component
public class ManagerLocationRepositoryImpl {
    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private ManagerLocationRepository repository;

    @SuppressWarnings("unused")
    public Iterable<ManagerLocation> findByLocationId(String location_id){
        String queryText = "SELECT * FROM managerassert WHERE location_id = :location_id";
        Query query = entityManager.createNativeQuery(queryText, ManagerLocation.class);
        query.setParameter("assert_id", assert_id);
        return query.getResultList();
    }
}
