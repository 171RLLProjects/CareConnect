package com.mphasis.ocs.daos;

 

import java.util.List;

 

import com.mphasis.ocs.pojos.Appointment;
import com.mphasis.ocs.pojos.Doctor;
import com.mphasis.ocs.pojos.Leave;

 

public interface DoctorDao {
    public void insertDoctor(Doctor d);
    public void updatedoctor(Doctor d);
    public void deletedoctor(String did);
    public List<Doctor> getAll();
    public Doctor getDoctorById(String did);
    public Doctor login(String did,String password);

 

    

 

}