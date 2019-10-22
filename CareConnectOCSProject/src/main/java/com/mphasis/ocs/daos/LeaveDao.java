package com.mphasis.ocs.daos;

import java.util.List;

import com.mphasis.ocs.pojos.Doctor;
import com.mphasis.ocs.pojos.Leave;

public interface LeaveDao {
public String insertLeave(Leave l);
public void updateLeave(Leave l);
public List<Leave> getLeavesByStatus(String status);
public List<Leave> getLeavesByDoctor(Doctor doctor);
public Leave getLeaveById(String lid);
}