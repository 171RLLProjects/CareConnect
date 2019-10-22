package com.mphasis.ocs.services;

 

import com.mphasis.ocs.exceptions.BusinessException;
import com.mphasis.ocs.pojos.Patient;

 

public interface PatientService {
public Patient login(String pid,String password)throws BusinessException;
public String addPatient(Patient p)throws BusinessException;
public void updatePatient(Patient p)throws BusinessException;
public void deletePatient(String pid)throws BusinessException;
public void addSymptom(String symptom,String pid);
//public Patient viewProfile(String pid)throws BusinessException;
public Patient getPatientById(String pid)throws BusinessException;

 

}