package com.mphasis.ocs.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mphasis.ocs.exceptions.BusinessException;
import com.mphasis.ocs.pojos.Admin;
import com.mphasis.ocs.pojos.Appointment;
import com.mphasis.ocs.pojos.Doctor;
import com.mphasis.ocs.pojos.Patient;
import com.mphasis.ocs.pojos.Reporter;
import com.mphasis.ocs.services.AdminService;
import com.mphasis.ocs.services.AppointmentService;
import com.mphasis.ocs.services.DoctorService;
import com.mphasis.ocs.services.PatientService;
import com.mphasis.ocs.services.ReporterService;

@RestController
public class DemoController {

	@Autowired
	DoctorService doctorService;
	@Autowired
	PatientService patientService;
	@Autowired
	AdminService adminService;
	@Autowired
	ReporterService reporterService;
	@Autowired
	AppointmentService appointmentService;

	@RequestMapping(value="/getalldoctors",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Doctor> getDoctors(){
		List<Doctor> doctors=null;
		try {
			doctors=doctorService.getAll();
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return doctors;		
	}
	@RequestMapping(value="/adddoctor",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Map<String,String>>addDoctor(@RequestBody Doctor d){	
		Map<String, String> response=new HashMap<>();
		try {
			doctorService.insertDoctor(d);
			response.put("ok", "success saving data");
			return ResponseEntity.accepted().body(response);
		} catch (BusinessException e) {
			response.put("error", e.getMessage());
			return ResponseEntity.badRequest().body(response);
		}
	}
	@RequestMapping(value="/updatedoctor",method=RequestMethod.PUT,produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Map<String,String>>updateDoctor(@RequestBody Doctor d){	
		Map<String, String> response=new HashMap<>();
		try {
			System.err.println(d.getPassword());
			doctorService.updatedoctor(d);
			response.put("ok", "success saving data");
			return ResponseEntity.accepted().body(response);
		} catch (BusinessException e) {
			response.put("error", e.getMessage());
			return ResponseEntity.badRequest().body(response);
		}
	}
	@RequestMapping(value="/deletedoctor/{did}",method=RequestMethod.DELETE,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void>deleteDoctors(@PathVariable("did")String did){	
		try {
			doctorService.deletedoctor(did);
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(HttpStatus.OK);			
	}
	@RequestMapping(value="/doctorlogin/{did}/{password}",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	public Doctor login(@PathVariable("did")String did,@PathVariable("password")String password) {
		Doctor doctor=null;
		try {
			doctor=doctorService.login(did, password);
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return doctor;

	}
	@RequestMapping(value="/getdoctorbyid/{did}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public Doctor getDoctorById(@PathVariable("did")String did) {
		Doctor doctor=null;
		try {
			doctor=doctorService.getDoctorById(did);

		}catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return doctor;
	}
	@RequestMapping(value="/getdoctorsbylocandsym/{pid}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Doctor> getDoctors(@PathVariable("pid")String pid){	
		//Map<String, String> response=new HashMap<>();
		List<Doctor> doctors=null;
		try {
			doctors=doctorService.getDoctorsByLocSym(pid);
			/*response.put("ok", "success saving data");
			return ResponseEntity.accepted().body(response);*/
		} catch (BusinessException e) {
			//response.put("error", e.getMessage());
			e.printStackTrace();
		}
		return doctors;
	}
	@RequestMapping(value="/adminlogin/{aid}/{password}",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	public Admin login1(@PathVariable("aid")String aid,@PathVariable("password")String password) {
		Admin admin=null;
		try {
			admin=adminService.login(aid, password);
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return admin;
	}
	@RequestMapping(value="/addadmin",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Map<String,String>>addAdmin1(@RequestBody Admin a){	
		Map<String, String> response=new HashMap<>();
		try {
			adminService.addAdmin(a);
			response.put("ok", "success saving data");
			return ResponseEntity.accepted().body(response);
		} catch (BusinessException e) {
			response.put("error", e.getMessage());
			return ResponseEntity.badRequest().body(response);
		}
	}
	@RequestMapping(value="/addreporter",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Map<String,String>>addReporter(@RequestBody Reporter r){	
		Map<String, String> response=new HashMap<>();
		try {
			reporterService.insertReporter(r);
			response.put("ok", "success saving data");
			return ResponseEntity.accepted().body(response);
		} catch (BusinessException e) {
			response.put("error", e.getMessage());
			return ResponseEntity.badRequest().body(response);
		}

	}
	@RequestMapping(value="/reporterlogin/{rid}/{password}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public Reporter login2(@PathVariable("rid")String rid,@PathVariable("password")String password) {
		Reporter reporter=null;
		try {
			reporter=reporterService.login(rid, password);
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return reporter;
	}
	@RequestMapping(value="/updatereporter",method=RequestMethod.PUT,produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody

	public ResponseEntity<Map<String,String>>updateReporter1(@RequestBody Reporter r ){	
		Map<String, String> response=new HashMap<>();
		try {
			reporterService.updateReporter(r);
			response.put("ok", "success saving data");
			return ResponseEntity.accepted().body(response);
		} catch (BusinessException e) {
			response.put("error", e.getMessage());
			return ResponseEntity.badRequest().body(response);
		}
	}
	@RequestMapping(value="/deletereporter/{rid}",method=RequestMethod.DELETE,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void>deletereporter1(@PathVariable("rid")String rid){	
		try {
			System.out.println("hloooooooooooooo");
			reporterService.deleteReporter(rid);
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(HttpStatus.OK);			
	}
	@RequestMapping(value="/getreporterbyid/{rid}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public Reporter getReporterById(@PathVariable("rid")String rid) {
		Reporter reporter=null;
		try {
			reporter=reporterService.getReporterById(rid);

		}catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return reporter;
	}
	@RequestMapping(value="/addappointment/{date}/{pid}/{did}",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Map<String,String>>addAppointment(@PathVariable("date")String date,@PathVariable("pid")String pid
			,@PathVariable("did")String did) {	

		Patient p=null;
		Doctor d=null;
		Map<String, String> response=new HashMap<>();
		Appointment a1=new Appointment();
		a1.setStatus("pending");
		date=date.replace("-","/");
		SimpleDateFormat formatter1=new SimpleDateFormat("dd/MM/yyyy");
		 Date date1=null;
		try {
			date1 = formatter1.parse(date);
			System.out.println(date1+"hlooooooooooooooo");
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		try {
			p=patientService.getPatientById(pid);
			a1.setPatient(p);
			d=doctorService.getDoctorById(did);
			a1.setDoctor(d);
			a1.setAppointmentDate(date1);
			appointmentService.insertAppointment(a1);
			response.put("ok", "success saving data");
			return ResponseEntity.accepted().body(response);
		}


		catch(BusinessException e) {
			e.printStackTrace();
			response.put("error", e.getMessage());
			return ResponseEntity.badRequest().body(response);
		}
	}
	@RequestMapping(value="/updateappointment",method=RequestMethod.PUT,produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Map<String,String>>updateAppointment(@RequestBody Appointment a){	
		Map<String, String> response=new HashMap<>();
		appointmentService.updateAppointment(a);
		response.put("ok", "success saving data");
		return ResponseEntity.accepted().body(response);
	}
	@RequestMapping(value="/deleteappointment/{aid}",method=RequestMethod.DELETE,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void>deleteappointments(@PathVariable("aid")String aid){	
		appointmentService.deleteAppointment(aid);
		return new ResponseEntity<>(HttpStatus.OK);			
	}
	@RequestMapping(value="/getappointmentsbypatient",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Appointment> getAppointments(@RequestBody Patient p){
		List<Appointment> appointments=null;
		try {
			appointments=appointmentService.getAppointmentsByPatient(p);
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return appointments;		
	}
	@RequestMapping(value="/getappointmentsbydoctor/{did}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Appointment> getAppointments(@PathVariable("did")String did){
		List<Appointment> appointments=null;
		try {
			String status="approved";
			appointments=appointmentService.getAppointmentsByDoctor(did);
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return appointments;		
	}
	@RequestMapping(value="/getappointmentsbystatus",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Appointment> getAppointments(){
		List<Appointment> appointments=null;
		try {

			appointments=appointmentService.getAppointmentsByStatus("pending");
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return appointments;		
	}
	@RequestMapping(value="/checkandReqAppointment/{date}/{pid}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public int getAppointments(@PathVariable("date")String date,@PathVariable("pid")String pid){
		
		int i;
		date=date.replace("-","/");
		SimpleDateFormat formatter1=new SimpleDateFormat("dd/MM/yyyy");
		 Date date1=null;
		try {
			date1 = formatter1.parse(date);
		
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		

			i=appointmentService.checkandReqAppointment(date1,pid);
		
		return i;		
	}

}
