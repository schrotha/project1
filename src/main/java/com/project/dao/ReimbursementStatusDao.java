package com.project.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.project.model.ReimburesementStatus;
import com.project.util.HibernateUtil;

public class ReimbursementStatusDao {

	private HibernateUtil hUtil;
	
	public ReimbursementStatusDao() {
		// TODO Auto-generated constructor stub
	}

	public ReimbursementStatusDao(HibernateUtil hUtil) {
		super();
		this.hUtil = hUtil;
	}
	
	public void insert(ReimburesementStatus rStat) {
		Session ses = hUtil.getSession();
		Transaction tx = ses.beginTransaction();
		
		ses.save(rStat);
		tx.commit();
	}
	
	public void update(ReimburesementStatus rStat) {
		Session ses = hUtil.getSession();
		Transaction tx = ses.beginTransaction();
		
		ses.update(rStat);
		tx.commit();
	}
	
	public ReimburesementStatus selectByStatus(String status) {
		Session ses = hUtil.getSession();
		
		ReimburesementStatus rStat = ses.get(ReimburesementStatus.class, status);
		
		return rStat;
	}
	
}
