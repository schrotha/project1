package com.project.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.project.model.UserRole;
import com.project.util.HibernateUtil;

public class UserRoleDao {

	private HibernateUtil hUtil;
	
	public UserRoleDao() {
		// TODO Auto-generated constructor stub
	}

	public UserRoleDao(HibernateUtil hUtil) {
		super();
		this.hUtil = hUtil;
	}
	
	public void insert(UserRole uRole) {
		Session ses = hUtil.getSession();
		Transaction tx = ses.beginTransaction();
		
		ses.save(uRole);
		tx.commit();
		
	}
	
	public void update(UserRole uRole) {
		Session ses = hUtil.getSession();
		Transaction tx = ses.beginTransaction();
		
		ses.update(uRole);
		tx.commit();
		
	}
	
	public UserRole selectByRole(String role) {
		Session ses = hUtil.getSession();
		
		UserRole uRole = ses.get(UserRole.class, role);
		
		return uRole;
	}
	
}
