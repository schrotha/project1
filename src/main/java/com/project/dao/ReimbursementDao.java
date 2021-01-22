package com.project.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.project.model.Reimbursement;
import com.project.util.HibernateUtil;

public class ReimbursementDao {

	private HibernateUtil hUtil;
	
	public ReimbursementDao() {
		// TODO Auto-generated constructor stub
	}

	public ReimbursementDao(HibernateUtil hUtil) {
		super();
		this.hUtil = hUtil;
	}
	
	public void insert(Reimbursement r) {
		Session ses = hUtil.getSession();
		Transaction tx = ses.beginTransaction();
		
		ses.save(r);
		tx.commit();
	}
	
	public void update(Reimbursement r) {
		Session ses = hUtil.getSession();
		Transaction tx = ses.beginTransaction();
		
		ses.update(r);
		tx.commit();
	}
	
	public Reimbursement selectById(int id) {
		Session ses = hUtil.getSession();
		
		Reimbursement r = ses.get(Reimbursement.class, id);
		return r;
	}
	
	public List<Reimbursement> selectByUser(String username){
		Session ses = hUtil.getSession();
		List<Reimbursement> rList = ses.createQuery("FROM Reimbursement WHERE User_FK ='" + username + "'", Reimbursement.class).list();
		return rList;
	}
	
	public List<Reimbursement> selectPending(){
		Session ses = hUtil.getSession();
		List<Reimbursement> rList = ses.createQuery("FROM Reimbursement WHERE status = 'Pending'", Reimbursement.class).list();
		return rList;
	}
	
	public List<Reimbursement> selectHistory(){
		Session ses = hUtil.getSession();
		List<Reimbursement> rList = ses.createQuery("FROM Reimbursement WHERE status != 'Pending'", Reimbursement.class).list();
		return rList;
	}
}
