package com.mphasis.ocs.services;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mphasis.ocs.daos.AppointmentDao;
import com.mphasis.ocs.daos.DoctorDao;
import com.mphasis.ocs.daos.PatientDao;
import com.mphasis.ocs.exceptions.BusinessException;
import com.mphasis.ocs.pojos.Appointment;
import com.mphasis.ocs.pojos.Doctor;
import com.mphasis.ocs.pojos.Patient;
@Service
public class AppointmentServiceImpl implements AppointmentService {
	@Autowired
	private AppointmentDao appointmentDao;
	@Autowired
	private PatientDao patientDao;
	@Autowired
	private DoctorDao doctorDao;
	public void updateAppointment(Appointment a)  {
appointmentDao.updateAppointment(a);
	}

	public Appointment getAppointmentsById(String aid)  {
		return appointmentDao.getAppointmentsById(aid);
	}

	public void insertAppointment(Appointment a) {
 appointmentDao.insertAppointment(a);
	}

	public void deleteAppointment(String aid) {
	appointmentDao.deleteAppointment(aid);

	}

	public List<Appointment> getAppointmentsByPatient(Patient patient) throws BusinessException {
		List<Appointment> appointments=appointmentDao.getAppointmentsByPatient(patient);
		if(appointments.isEmpty()) {
			throw new BusinessException("You dont have any appointments");
		}
		return appointments;
	}

	public List<Appointment> getAppointmentsByStatus(String s) throws BusinessException {
		List<Appointment> appointments=appointmentDao.getAppointmentsByStatus(s);
		if(appointments.isEmpty()) {
			throw new BusinessException("No appointments available");
		}
		return appointments;
	}

	

	public List<Appointment> getAppointmentsByDoctor(String did) throws BusinessException {
		Doctor d=doctorDao.getDoctorById(did);
		 String pattern="dd-MM-yyyy";
	        SimpleDateFormat formatter=new SimpleDateFormat(pattern);
	        String date=formatter.format(new Date());
	        System.out.println(date);
	        SimpleDateFormat formatter1=new SimpleDateFormat(pattern);
	        Date date2=null;
			try {
				date2 = formatter1.parse(date);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(date2);
		List<Appointment> appointments=appointmentDao.getAppointmentsByDoctor(d,date2);
		if(appointments.isEmpty()) {
			throw new BusinessException("No appointments");
		}
		return appointments;
	}
	

 

    public int checkandReqAppointment(Date reqDate, String pid) {
        int flag = 0;
        Patient p=patientDao.getPatientById(pid);
        System.out.println(p+"patient object");
        List<Appointment> appointments=appointmentDao.getAppointmentsByPatient(p);
         System.out.println(appointments+"appp object");
		for(Appointment aps:appointments) {
			System.out.println("data from database"+aps.getAppointmentDate());
		}
		 
		/*LocalDate today = LocalDate.now();
		 
		String formattedDate = today.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		 System.out.println(formattedDate+"in service for current date");
		// s.replace("-","/");
	        SimpleDateFormat formatter1=new SimpleDateFormat("dd/MM/yyyy");
			 Date date1=null;
			try {
				date1 = formatter1.parse(formattedDate);
				System.out.println(date1+"after parsig");
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}*/
		String pattern="dd-mm-yyyy";
        SimpleDateFormat formatter=new SimpleDateFormat(pattern);
        String date=formatter.format(new Date());
    
        SimpleDateFormat formatter1=new SimpleDateFormat(pattern);
        Date date1=null;
		try {
			date1 = formatter1.parse(date);
			System.out.println(date1+ "current date");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
        if(appointments.isEmpty())
        {
           
            return 1;
        }
        else
        {
            for (Appointment appointment : appointments) {
            	
                if(((appointment.getAppointmentDate()).equals(date1)) || ((appointment.getAppointmentDate()).after(date1)))
                {
                
                	System.out.println("flag was set to 1");
                    flag=1;
                }
            }
        }

 

        if(flag == 0)
        {
            //Appointment a=appointmentDao.getAppointmentsById(appid);
            //appointmentDao.insertAppointment(a);
        	
            return 1;
        }
        else
        {
        	
            return 0;
    }
    }

}
