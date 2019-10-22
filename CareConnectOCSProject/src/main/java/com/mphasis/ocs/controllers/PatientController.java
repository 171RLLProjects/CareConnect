package com.mphasis.ocs.controllers;

 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

 

import com.mphasis.ocs.exceptions.BusinessException;
import com.mphasis.ocs.pojos.Patient;
import com.mphasis.ocs.services.PatientService;

 

@RestController
public class PatientController {

 

    @Autowired
    PatientService patientService;

 

    @RequestMapping(value = "/login/{patientid}/{pwd}", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE )

 

    public Patient login(@PathVariable("patientid")String pid,@PathVariable("pwd")String password) throws BusinessException 
    {
        try {
            return patientService.login(pid, password);
        }
        catch(BusinessException e)
        {
            throw new BusinessException("invalid credentails");
        }
    }

 

    @RequestMapping(value = "/addpatient", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE )
    public String register(@RequestBody Patient p) throws BusinessException 
    {
        return patientService.addPatient(p);
    }

 

    @RequestMapping(value = "/updatepatient", method = RequestMethod.PUT,produces = MediaType.APPLICATION_JSON_VALUE )
    public void updatePatient(@RequestBody Patient p) throws BusinessException 
    {
         patientService.updatePatient(p);
    }

 

    @RequestMapping(value = "/deletepatient/{pid}",method = RequestMethod.DELETE,produces= MediaType.APPLICATION_JSON_VALUE)
    public void deletePatient(@PathVariable("pid")String pid) throws BusinessException
    {
        try {
            patientService.deletePatient(pid);
        }
        catch(Exception e)
        {
            throw new BusinessException("deletion not working");
        }
    }

 

    @RequestMapping(value = "/getpatientbyid/{pid}",method = RequestMethod.GET,produces= MediaType.APPLICATION_JSON_VALUE)
    public Patient getPatientById(@PathVariable("pid")String pid) throws BusinessException
    {
        return patientService.getPatientById(pid);
    }

 

    @RequestMapping(value = "/patient/{pid}/{symptom}",method = RequestMethod.PUT,produces= MediaType.APPLICATION_JSON_VALUE)
    public void addSymptom(@PathVariable("pid")String pid,@PathVariable("symptom")String symptom) throws BusinessException
    {
        patientService.addSymptom(symptom, pid);
    }
}