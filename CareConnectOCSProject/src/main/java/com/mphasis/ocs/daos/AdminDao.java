package com.mphasis.ocs.daos;

import com.mphasis.ocs.pojos.Admin;

public interface AdminDao {
	public Admin login(String pid,String password);
public void addAdmin(Admin admin);

}
