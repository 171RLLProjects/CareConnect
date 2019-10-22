package com.mphasis.ocs.services;

import java.util.List;

import com.mphasis.ocs.exceptions.BusinessException;
import com.mphasis.ocs.pojos.Doctor;
import com.mphasis.ocs.pojos.Leave;

public interface LeaveService {
	public String insertLeave(Leave l);
	public void updateLeave(Leave l);
	public List<Leave> getLeavesByStatus(String status)throws BusinessException;
	public List<Leave> getLeavesByDoctor(Doctor doctor)throws BusinessException;
	public Leave getLeaveById(String lid);
	public int checkAndReqLeave(String did);
}
