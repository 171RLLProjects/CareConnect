package com.mphasis.ocs.daos;

 

import java.util.List;

 

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

 

import com.mphasis.ocs.pojos.Location;
@Repository
public class LocationDaoImpl implements LocationDao {

 

    @Autowired
    SessionFactory sessionFactory;
    public void addLocation(Location l) {
        Session session=sessionFactory.openSession();
        session.beginTransaction();
        session.save(l);
        session.getTransaction().commit();
        session.close();

 

    }

 

    public void updateLocation(Location l) {
        Session session=sessionFactory.openSession();
        session.beginTransaction();
        session.update(l);
        session.getTransaction().commit();
        session.close();

 

    }

 

    public void deleteLocation(String locid) {
        Session session=sessionFactory.openSession();
        session.beginTransaction();
        Location l=session.get(Location.class,locid);
        session.delete(l);
        session.getTransaction().commit();
        session.close();

 

    }

 

    public List<Location> getAllLocations() {
        Session session=sessionFactory.openSession();
        List<Location> locations=session.createCriteria(Location.class).list();
        return locations;
    }

 

    public Location getLocationById(String locid) {
        Session session=sessionFactory.openSession();
        session.beginTransaction();
        Location l=session.get(Location.class,locid);
        session.getTransaction().commit();
        session.close();
        return l;
    }

 

}