    
package com.mphasis.ocs.services;


import java.util.List;


import com.mphasis.ocs.exceptions.BusinessException;
import com.mphasis.ocs.pojos.Location;


public interface LocationService {
    public void addLocation(Location l)throws BusinessException;
    public void updateLocation(Location l)throws BusinessException;
    public void deleteLocation(String locid)throws BusinessException;
    public Location getLocationById(String locid) throws BusinessException;
    public List<Location> getAllLocations();
}
 





