package com.mphasis.ocs.daos;

import java.util.List;

import com.mphasis.ocs.pojos.Appointment;
import com.mphasis.ocs.pojos.Doctor;
import com.mphasis.ocs.pojos.Patient;

public interface PatientDao {
	public Patient login(String pid,String password);
    public String addPatient(Patient p);
    public void updatePatient(Patient p);
    public void deletePatient(String pid);
    public void addSymptom(String symptom,String pid);
    //public Patient viewProfile(String pid);
    public Patient getPatientById(String pid);
    

 
	
	
	
	

}
