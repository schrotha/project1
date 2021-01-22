package com.project.service;

import com.project.dao.UserRoleDao;
import com.project.model.UserRole;

public class UserRoleService {

	private UserRoleDao uRoleDao;
	
	public UserRoleService() {
		// TODO Auto-generated constructor stub
	}

	public UserRoleService(UserRoleDao uRoleDao) {
		super();
		this.uRoleDao = uRoleDao;
	}
	
	public UserRole selectByRole(String role) {
		UserRole uRole = uRoleDao.selectByRole(role);
		return uRole;
	}
	
}
