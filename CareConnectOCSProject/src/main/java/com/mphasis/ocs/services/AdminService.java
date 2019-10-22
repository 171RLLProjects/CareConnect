package com.mphasis.ocs.services;

import com.mphasis.ocs.exceptions.BusinessException;
import com.mphasis.ocs.pojos.Admin;

public interface AdminService {
	public Admin login(String pid,String password)throws BusinessException;
	public void addAdmin(Admin admin)throws BusinessException;
}
