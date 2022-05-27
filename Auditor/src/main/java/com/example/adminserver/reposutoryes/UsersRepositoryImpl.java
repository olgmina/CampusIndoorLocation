package com.example.adminserver.reposutoryes;

import com.example.adminserver.models.Organizational;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Component
public class UsersRepositoryImpl {
    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private UsersRepository repository;

    @SuppressWarnings("unused")
    public int findByCategory(String category){
        String queryText = "SELECT * FROM Organizational WHERE category = :category";
        Query query = entityManager.createNativeQuery(queryText, Organizational.class);
        query.setParameter("category", category);
        return query.getResultList().size();
    }

    @SuppressWarnings("unused")
    public int findByStatus(String status){
        String queryText = "SELECT * FROM Organizational WHERE status = :status";
        Query query = entityManager.createNativeQuery(queryText, Organizational.class);
        query.setParameter("status", status);
        return query.getResultList().size();
    }
}
