package org.example.dao;

import org.example.entity.Location;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.management.Query;
import java.util.List;

@Repository
public class ImplDaoLocation implements DaoLocation{
    @Autowired
    SessionFactory sessionFactory;
    @Override
    public List<Location> showLocation() {
        Session session = sessionFactory.openSession();
        List<Location> locationList = session.createQuery("from Location", Location.class).getResultList();
        return locationList;
    }

    @Override
    public void addLocation(Location location) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(location);
    }

    @Override
    public void deleteLocation(int id) {
        Session session = sessionFactory.getCurrentSession();
        Location location = session.get(Location.class, id);
        session.delete(location);
    }

    @Override
    public Location getLocation(int id) {
        Session session = sessionFactory.getCurrentSession();
        Location location = session.get(Location.class, id);
        return  location;
    }
}
