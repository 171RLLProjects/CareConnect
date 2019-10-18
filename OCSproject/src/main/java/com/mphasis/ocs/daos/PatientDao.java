package com.mphasis.ocs.daos;

import java.util.List;

import com.mphasis.ocs.pojos.Appointment;
import com.mphasis.ocs.pojos.Doctor;
import com.mphasis.ocs.pojos.Patient;

public interface PatientDao {
	public void login(String pid,String password);
	public void addPatient(Patient p);
	public void updatePatient(Patient p);
	public void deletePatient(Patient p);
	public void addSymptom(Patient p);
	public List<Doctor> getDoctorBySymptomLocation(String symptom);
	public Doctor chooseDoctorByPatient(Doctor did);
	public void confirmAppointment(Appointment a);
	
	
	
	

}
