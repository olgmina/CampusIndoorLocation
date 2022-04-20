package com.example.managerstaff.repository;

import com.example.managerstaff.model.ManagerStaff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Component
public class ManagerStaffRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private ManagerStaffRepository repository;

    @SuppressWarnings("unused")
    public Iterable<ManagerStaff> findByStaffId(String staff_id){
        String queryText = "SELECT * FROM managerstaff WHERE staff_id = : staff_id";
        Query query = entityManager.createNativeQuery(queryText, ManagerStaff.class);
        query.setParameter("staff_id", staff_id);
        return query.getResultList();
    }

    public Object findAll() {
    }

    public ManagerStaff save(ManagerStaff managerStaff) {
    }

    public void delete(ManagerStaff build) {
    }
}
