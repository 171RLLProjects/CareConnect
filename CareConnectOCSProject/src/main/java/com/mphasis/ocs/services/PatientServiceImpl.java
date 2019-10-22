package com.mphasis.ocs.services;

 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mphasis.ocs.daos.PatientDao;
import com.mphasis.ocs.exceptions.BusinessException;
import com.mphasis.ocs.pojos.Patient;
@Service
public class PatientServiceImpl implements PatientService {

 

    @Autowired
    PatientDao patientDao;
    public Patient login(String pid, String password) throws BusinessException {

 

        Patient patient=patientDao.login(pid, password);
        if(patient == null)
        {
            throw new BusinessException("invalid credintials");
        }
        return patient;
    }

 

    public String addPatient(Patient p) throws BusinessException {
        String s=null;
    	if(p.getPname().matches("[A-Za-z]{3,20}"))
        {
            if(p.getPassword().matches("[A-Za-z]{3,10}"))
            {
                s=patientDao.addPatient(p);
            }
            else
            {
                throw new BusinessException("password should be between 3 and 10 characters");
            }
        }
        else
        {
            throw new BusinessException("name should be between 3 and 20 characters");
        }
    	return s;
    }

 

    public void updatePatient(Patient p) throws BusinessException {
        if(p.getPname().matches("[A-Za-z]{3,20}"))
        {
            if(p.getPassword().matches("[A-Za-z]{3,10}"))
            {
                patientDao.updatePatient(p);
            }
            else
            {
                throw new BusinessException("password should be between 3 and 10 characters");
            }
        }
        else
        {
            throw new BusinessException("name should be between 3 and 20 characters");
        }

 

    }

 

    public void deletePatient(String pid) {
        patientDao.deletePatient(pid);
    }

 

    public void addSymptom(String symptom, String pid) {
        patientDao.addSymptom(symptom, pid);
    }

 

    /*public Patient viewProfile(String pid) throws BusinessException {

 

        Patient p=patientDao.viewProfile(pid);
        if(p == null) 
        {
            throw new BusinessException("patient profile is not available");    
        }
        return p;
    }*/

 

 

    public Patient getPatientById(String pid) throws BusinessException {

 

        Patient p=patientDao.getPatientById(pid);
        if(p == null) 
        {
            throw new BusinessException("patient is not available");    
        }
        return p;
    }

 

}
 