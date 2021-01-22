package com.project.service;

import com.project.dao.UserDao;
import com.project.dao.UserRoleDao;
import com.project.model.User;
import com.project.model.UserRole;

public class UserService {

	private UserDao uDao;
	
	public UserService() {
		// TODO Auto-generated constructor stub
	}

	public UserService(UserDao uDao) {
		super();
		this.uDao = uDao;
	}
	
	public User getUser(String uName) {
		User user = uDao.selectByUsername(uName);
		return user;
	}
	
	public boolean verifyPassword(String uName, String password) {
		boolean isVerified = false;
		User u = getUser(uName);
		if(u == null) {
			return false;
		}
		else if(u.getPassword().equals(password)) {
			isVerified = true;
		}
		return isVerified;
	}
	
	public boolean createUser(String username, String password, String fName, String lName, String email, UserRole role) {
		boolean createSuccessful = false;
		if(getUser(username) == null) {
			User newUser = new User(username, password, fName, lName, email, role);
			uDao.insert(newUser);
			createSuccessful = true;
		}
		return createSuccessful;
	}
	
	public String getUserRole(String username) {
		User u = getUser(username);
		String role = u.getRole();
		return role;
	}
	
}
