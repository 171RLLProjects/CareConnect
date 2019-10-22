package com.mphasis.ocs.daos;

 

import java.util.List;

 

import com.mphasis.ocs.pojos.Doctor;
import com.mphasis.ocs.pojos.Reporter;

 

public interface ReporterDao {
    public void insertReporter(Reporter r);
    public void updateReporter(Reporter r);
    public void deleteReporter(String rid);
    public Reporter login(String repid,String password);
    public Reporter getReporterById(String rid);

 

}