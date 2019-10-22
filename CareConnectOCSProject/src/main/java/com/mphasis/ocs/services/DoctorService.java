package com.mphasis.ocs.services;

 

import java.util.List;

 

import com.mphasis.ocs.pojos.Doctor;
import com.mphasis.ocs.exceptions.BusinessException;

 

public interface DoctorService {
    
    public void insertDoctor(Doctor d)throws BusinessException;
    public void updatedoctor(Doctor d)throws BusinessException;
    public void deletedoctor(String did)throws BusinessException;
    public List<Doctor> getAll()throws BusinessException;
    public Doctor getDoctorById(String did)throws BusinessException;
    public Doctor login(String did,String password)throws BusinessException;
    public List<Doctor> getDoctorsByLocSym(String pid)throws BusinessException;
    

 

}