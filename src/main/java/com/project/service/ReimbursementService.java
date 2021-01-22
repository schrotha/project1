package com.project.service;

import java.util.List;

import com.project.dao.ReimbursementDao;
import com.project.model.ReimburesementStatus;
import com.project.model.Reimbursement;
import com.project.model.ReimbursementType;
import com.project.model.User;
import com.project.model.UserRole;

public class ReimbursementService {

	private ReimbursementDao rDao;
	
	public ReimbursementService() {
		// TODO Auto-generated constructor stub
	}

	public ReimbursementService(ReimbursementDao rDao) {
		super();
		this.rDao = rDao;
	}
	
	public void createReimbursement(String amount, String description, User user, ReimbursementType rType, ReimburesementStatus rStat) {
		Reimbursement r = new Reimbursement(amount, description, user, rType, rStat);
		rDao.insert(r);
	}
	
	public List<Reimbursement> getReimbursementByUser(User user) {
		
		return rDao.selectByUser(user.getUsername());
	}
	
	public List<Reimbursement> getPendingReimbursements() {
		
		return rDao.selectPending();
	}
	
	public List<Reimbursement> getHistoryReimbursements() {
		
		return rDao.selectHistory();
	}
	
	public void approveReimbursement(String id) {
		Reimbursement r = rDao.selectById(Integer.parseInt(id));
		r.setStatus("Approved");
		rDao.update(r);
	}
	
	public void denyReimbursement(String id) {
		Reimbursement r = rDao.selectById(Integer.parseInt(id));
		r.setStatus("Denied");
		rDao.update(r);
	}
	
}
