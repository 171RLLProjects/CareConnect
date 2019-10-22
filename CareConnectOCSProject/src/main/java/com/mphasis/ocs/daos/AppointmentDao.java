package com.mphasis.ocs.daos;

import java.util.Date;
import java.util.List;

import com.mphasis.ocs.pojos.Appointment;
import com.mphasis.ocs.pojos.Doctor;
import com.mphasis.ocs.pojos.Patient;

public interface AppointmentDao {
public void updateAppointment(Appointment a);
public Appointment getAppointmentsById(String aid);
public void insertAppointment(Appointment a);
public void deleteAppointment(String aid);
public List<Appointment> getAppointmentsByPatient(Patient patient);
public List<Appointment> getAppointmentsByStatus(String s);
public List<Appointment> getAppointmentsByDoctor(Doctor doctor,Date date);

}
