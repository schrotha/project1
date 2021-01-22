package com.project.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.project.model.User;
import com.project.util.HibernateUtil;

public class UserDao {

	private HibernateUtil hUtil;
	
	public UserDao() {
		// TODO Auto-generated constructor stub
	}

	public UserDao(HibernateUtil hUtil) {
		super();
		this.hUtil = hUtil;
	}
	
	public void insert(User user) {
		Session ses = hUtil.getSession();
		Transaction tx = ses.beginTransaction();
		
		ses.save(user);
		tx.commit();
	}
	
	public void update(User user) {
		Session ses = hUtil.getSession();
		Transaction tx = ses.beginTransaction();
		
		ses.update(user);
		tx.commit();
	}
	
	public User selectByUsername(String uName) {
		Session ses = hUtil.getSession();
		
		User user = ses.get(User.class, uName);
		
		return user;
	}
}
