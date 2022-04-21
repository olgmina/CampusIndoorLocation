package com.example.managerstaff.repository;

import com.example.managerstaff.model.BusyTime;
import com.example.managerstaff.model.ManagerStaff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.time.LocalDateTime;
import java.util.Optional;

@Component
public class ManagerStaffRepositoryImpl {
    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private ManagerStaffRepository repository;

    @SuppressWarnings("unused")
    public Optional<ManagerStaff> findByStaffId(String staff_id){
        String queryText = "SELECT * FROM manager_staff WHERE staff_id = :staff_id";
        Query query = entityManager.createNativeQuery(queryText, ManagerStaff.class);
        query.setParameter("staff_id", staff_id);
        return query.getResultList().stream().findFirst();
    }


}
