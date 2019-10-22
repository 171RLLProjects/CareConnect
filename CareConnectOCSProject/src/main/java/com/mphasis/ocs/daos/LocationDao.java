package com.mphasis.ocs.daos;


import java.util.List;


import com.mphasis.ocs.pojos.Location;


public interface LocationDao {


	public void addLocation(Location l);
	public void updateLocation(Location l);
	public void deleteLocation(String locid);
	public Location getLocationById(String locid);
	public List<Location> getAllLocations();
}







