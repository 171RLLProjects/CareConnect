package com.mphasis.ocs.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mphasis.ocs.daos.AdminDao;
import com.mphasis.ocs.exceptions.BusinessException;
import com.mphasis.ocs.pojos.Admin;
@Service
public class AdminServiceImpl implements AdminService {
	@Autowired
	private AdminDao adminDao;
	public Admin login(String pid, String password) throws BusinessException {
		Admin user=adminDao.login(pid, password);
		if(user==null) {
			throw new BusinessException("invalid credentials");
		}
		return user;
	}

	public void addAdmin(Admin admin) throws BusinessException {
		if(admin.getAname().matches("[A-Za-z]{3,20}")) {
            if(admin.getPassword().matches(("[A-Za-z]{3,20}")/*&&("[0-9]{1,3}")*/)) {
                adminDao.addAdmin(admin);
            }else {
                throw new BusinessException("");
            }
            }
            else {
                throw new BusinessException("The name should contain only alphabets");
            }
        }
//	}else {
//	throw new BuisnessException("id range is 1 to 300");
//	}
	}


