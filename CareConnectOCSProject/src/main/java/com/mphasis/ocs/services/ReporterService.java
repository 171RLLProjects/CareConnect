package com.mphasis.ocs.services;

 

import com.mphasis.ocs.exceptions.BusinessException;
import com.mphasis.ocs.pojos.Reporter;

 

public interface ReporterService {
    
    public void insertReporter(Reporter r)throws BusinessException;
    public void updateReporter(Reporter r)throws BusinessException;
    public void deleteReporter(String rid)throws BusinessException;
    public Reporter login(String repid,String password)throws BusinessException;
    public Reporter getReporterById(String rid)throws BusinessException;

 

}