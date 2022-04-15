package org.example.dao;

import org.example.entity.Location;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class ImplDaoLocation implements Dao<Location> {
    @Autowired
    SessionFactory sessionFactory;

    @Override
    @Transactional
    public List<Location> showLocation() {
        Session session = sessionFactory.openSession();
        List<Location> locationList = session.createQuery("from Location", Location.class).getResultList();
        return locationList;
    }

    @Override
    @Transactional
    public void addLocation(Location location) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(location);
    }

    @Override
    @Transactional
    public void deleteLocation(int id) {
        Session session = sessionFactory.getCurrentSession();
        Location location = session.get(Location.class, id);
        session.delete(location);
    }

    @Override
    @Transactional
    public Location getLocation(int id) {
        Session session = sessionFactory.openSession();

        Query<Location> query = session.createQuery("from Location where id =: oneId",Location.class);
        query.setParameter("oneId", id);

        return query.getResultList().get(0);
    }
}
