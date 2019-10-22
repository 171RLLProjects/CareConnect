package com.mphasis.ocs.services;

 

import java.util.List;

 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

 

import com.mphasis.ocs.daos.LocationDao;
import com.mphasis.ocs.exceptions.BusinessException;
import com.mphasis.ocs.pojos.Location;
@Service
public class LocationServiceImpl implements LocationService {

 

    @Autowired
    LocationDao locationDao;
    public void addLocation(Location l) throws BusinessException {
        locationDao.addLocation(l);

 

    }

 

    public void updateLocation(Location l) throws BusinessException {
    locationDao.updateLocation(l);

 

    }

 

    public void deleteLocation(String locid) throws BusinessException {
        locationDao.deleteLocation(locid);

 

    }

 

    public Location getLocationById(String locid) throws BusinessException {
        
        Location l=locationDao.getLocationById(locid);
        if(l == null) 
        {
            throw new BusinessException("location is not available");    
        }
        return l;
    }
    

 

    public List<Location> getAllLocations() {
    
        return locationDao.getAllLocations();
    }

 

}