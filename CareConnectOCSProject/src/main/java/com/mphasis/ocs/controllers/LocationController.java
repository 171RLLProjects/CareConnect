package com.mphasis.ocs.controllers;

 

import java.util.List;

 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

 

import com.mphasis.ocs.exceptions.BusinessException;
import com.mphasis.ocs.pojos.Location;
import com.mphasis.ocs.services.LocationService;

 

@RestController
public class LocationController {

 

    @Autowired
    LocationService locationService;

 

    @RequestMapping(value = "/addlocation", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE )
    public void addLocation(@RequestBody Location l) throws BusinessException 
    {
        locationService.addLocation(l);
    }

 

    @RequestMapping(value = "/updatelocation", method = RequestMethod.PUT,produces = MediaType.APPLICATION_JSON_VALUE )
    public void updateLocation(@RequestBody Location l) throws BusinessException 
    {
        locationService.updateLocation(l);;
    }

 

    @RequestMapping(value = "/deletel/{locid}",method = RequestMethod.DELETE,produces= MediaType.APPLICATION_JSON_VALUE)
    public void deleteLocation(@PathVariable("locid")String locid) 
    {
        try {
			locationService.deleteLocation(locid);
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

 

    @RequestMapping(value = "/getlocationbyid/{locid}",method = RequestMethod.GET,produces= MediaType.APPLICATION_JSON_VALUE)
    public Location getLocationById(@PathVariable("locid")String locid) throws BusinessException
    {
        return locationService.getLocationById(locid);
    }

 

    @RequestMapping(value = "/locations",method = RequestMethod.GET,produces= MediaType.APPLICATION_JSON_VALUE)
    public List<Location> getAll() throws BusinessException
    {
        List<Location> locations=locationService.getAllLocations();
        return locations;
    }
}
