package com.project.service;

import com.project.dao.ReimbursementTypeDao;
import com.project.model.ReimbursementType;
import com.project.model.UserRole;

public class ReimbursementTypeService {
	
	private ReimbursementTypeDao rTypeDao;
	
	public ReimbursementTypeService() {
		// TODO Auto-generated constructor stub
	}

	public ReimbursementTypeService(ReimbursementTypeDao rTypeDao) {
		super();
		this.rTypeDao = rTypeDao;
	}
	
	public ReimbursementType selectByType(String type) {
		ReimbursementType rType = rTypeDao.selectByType(type);
		return rType;
	}
	
}
