package com.project.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.project.model.ReimbursementType;
import com.project.util.HibernateUtil;

public class ReimbursementTypeDao {

	private HibernateUtil hUtil;
	
	public ReimbursementTypeDao() {
		// TODO Auto-generated constructor stub
	}

	public ReimbursementTypeDao(HibernateUtil hUtil) {
		super();
		this.hUtil = hUtil;
	}
	
	public void insert(ReimbursementType rType) {
		Session ses = hUtil.getSession();
		Transaction tx = ses.beginTransaction();
		
		ses.save(rType);
		tx.commit();
	}
	
	public void update(ReimbursementType rType) {
		Session ses = hUtil.getSession();
		Transaction tx = ses.beginTransaction();
		
		ses.update(rType);
		tx.commit();
	}
	
	public ReimbursementType selectByType(String type) {
		Session ses = hUtil.getSession();
		
		ReimbursementType rType = ses.get(ReimbursementType.class, type);
		
		return rType;
	}
	
}
