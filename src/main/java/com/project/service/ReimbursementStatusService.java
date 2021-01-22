package com.project.service;

import com.project.dao.ReimbursementStatusDao;
import com.project.model.ReimburesementStatus;
import com.project.model.ReimbursementType;

public class ReimbursementStatusService {
	
	private ReimbursementStatusDao rStatDao;
	
	public ReimbursementStatusService() {
		// TODO Auto-generated constructor stub
	}

	public ReimbursementStatusService(ReimbursementStatusDao rStatDao) {
		super();
		this.rStatDao = rStatDao;
	}
	
	public ReimburesementStatus selectByStatus(String stat) {
		ReimburesementStatus rStat = rStatDao.selectByStatus(stat);
		return rStat;
	}
}
