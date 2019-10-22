package com.mphasis.ocs.services;

 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

 

import com.mphasis.ocs.daos.ReporterDao;
import com.mphasis.ocs.exceptions.BusinessException;
import com.mphasis.ocs.pojos.Doctor;
import com.mphasis.ocs.pojos.Reporter;
@Service
public class ReporterServiceImpl implements ReporterService{
    @Autowired
    ReporterDao reporterDao;

 

    public void insertReporter(Reporter r)throws BusinessException {
        if(r.getRname().matches("[A-Za-z]{3,20}")) {
            if(r.getPassword().matches(("[A-Za-z]{3,10}")/*&&("[0-9]{1,3}")*/)) {
                reporterDao.insertReporter(r);
            }else {
                throw new BusinessException("");
            }
            }
            else {
                throw new BusinessException("The name should contain only alphabets");
            }
        }
    

 

    public void updateReporter(Reporter r)throws BusinessException {
        if(r.getRname().matches("[A-Za-z]{3,20}")) {
            if(r.getPassword().matches(("[A-Za-z]{1,20}")/*&&("[0-9]{1,3}")*/)) {
                reporterDao.updateReporter(r);
            }else {
                throw new BusinessException("");
            }
            }
            else {
                throw new BusinessException("The name should contain only alphabets");
            }
        }
        

 

    public void deleteReporter(String rid)throws BusinessException {
        reporterDao.deleteReporter(rid);
    }

 

    public Reporter login(String repid, String password)throws BusinessException {
        Reporter reporter=reporterDao.login(repid, password);
        if(reporter==null)
        {
            throw new BusinessException("invalid credentails");
        }
        return reporter;
    }
        
    

 

    public Reporter getReporterById(String rid)throws BusinessException {
        Reporter reporter=reporterDao.getReporterById(rid);
        if(reporter==null)
        {
            throw new BusinessException("no reporter available");
        }
        return reporter;
        
    }

 

}