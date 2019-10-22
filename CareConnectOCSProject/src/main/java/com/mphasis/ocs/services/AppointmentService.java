package com.mphasis.ocs.services;

import java.util.Date;
import java.util.List;

import com.mphasis.ocs.exceptions.BusinessException;
import com.mphasis.ocs.pojos.Appointment;
import com.mphasis.ocs.pojos.Doctor;
import com.mphasis.ocs.pojos.Patient;

public interface AppointmentService {
	public void updateAppointment(Appointment a);
	public Appointment getAppointmentsById(String aid);
	public void insertAppointment(Appointment a);
	public void deleteAppointment(String aid);
	public List<Appointment> getAppointmentsByPatient(Patient patient)throws BusinessException;
	public List<Appointment> getAppointmentsByStatus(String s)throws BusinessException;
	public List<Appointment> getAppointmentsByDoctor(String did)throws BusinessException;
	public int checkandReqAppointment(Date date, String pid);
}
