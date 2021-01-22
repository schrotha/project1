package com.project;

import com.project.controller.UserController;
import com.project.dao.ReimbursementDao;
import com.project.dao.ReimbursementStatusDao;
import com.project.dao.ReimbursementTypeDao;
import com.project.dao.UserDao;
import com.project.dao.UserRoleDao;
import com.project.model.ReimburesementStatus;
import com.project.model.Reimbursement;
import com.project.model.ReimbursementType;
import com.project.model.User;
import com.project.model.UserRole;
import com.project.service.ReimbursementService;
import com.project.service.ReimbursementStatusService;
import com.project.service.ReimbursementTypeService;
import com.project.service.UserRoleService;
import com.project.service.UserService;
import com.project.util.HibernateUtil;

import io.javalin.Javalin;

public class MainDriver {

	// Initiate my hibernate util
	public static HibernateUtil hUtil = new HibernateUtil();
	
	// Initiate my dao's
	public static UserDao uDao = new UserDao(hUtil);
	public static UserRoleDao uRoleDao = new UserRoleDao(hUtil);
	public static ReimbursementDao rDao = new ReimbursementDao(hUtil);
	public static ReimbursementStatusDao rStatDao = new ReimbursementStatusDao(hUtil);
	public static ReimbursementTypeDao rTypeDao = new ReimbursementTypeDao(hUtil);
	
	// Initiate my services
	public static UserService uServ = new UserService(uDao);
	public static ReimbursementService rServ = new ReimbursementService(rDao);
	public static UserRoleService uRoleServ = new UserRoleService(uRoleDao);
	public static ReimbursementStatusService rStatServ = new ReimbursementStatusService(rStatDao);
	public static ReimbursementTypeService rTypeServ = new ReimbursementTypeService(rTypeDao);
	
	// Initiate my controller
	public static UserController uCon = new UserController(uServ, uRoleServ, rServ, rStatServ, rTypeServ);
	
	
	public static void main(String[] args) {
		
		insertInitialValues();
		
		Javalin app = Javalin.create(config ->{
			config.addStaticFiles("/frontend");
		});
		
		app.start(9050);
		
		app.post("/login", uCon.postLogin);
		app.post("/create-account", uCon.postCreateAccount);
		app.post("/create-reimbursement", uCon.postCreateReimbursement);
		app.get("/session", uCon.getSession);
		app.get("/manager/pending", uCon.getPendingReimbursements);
		app.get("/manager/history", uCon.getHistoryReimbursements);
		app.post("/resolve/approve/:id", uCon.postResolveApprove);
		app.post("/resolve/deny/:id", uCon.postResolveDeny);
		
	}
	
	public static void insertInitialValues() {
		// Insert User Roles
		UserRole uRole1 = new UserRole("Employee");
		UserRole uRole2 = new UserRole("Finance Manager");
		uRoleDao.insert(uRole1);
		uRoleDao.insert(uRole2);
		
		// Insert Reimbursement Types
		ReimbursementType rType1 = new ReimbursementType("LODGING");
		ReimbursementType rType2 = new ReimbursementType("TRAVEL");
		ReimbursementType rType3 = new ReimbursementType("FOOD");
		ReimbursementType rType4 = new ReimbursementType("OTHER");
		rTypeDao.insert(rType1);
		rTypeDao.insert(rType2);
		rTypeDao.insert(rType3);
		rTypeDao.insert(rType4);
		
		// Insert Reimbursement Statuses
		ReimburesementStatus rStat1 = new ReimburesementStatus("Pending");
		ReimburesementStatus rStat2 = new ReimburesementStatus("Approved");
		ReimburesementStatus rStat3 = new ReimburesementStatus("Denied");
		rStatDao.insert(rStat1);
		rStatDao.insert(rStat2);
		rStatDao.insert(rStat3);
		
		// Test user and reimbursement
		User u1 = new User("test account", "1234", "McLovin", "(not applicable)", "iliveinhawaii@yahoo.com", uRole1);
		User u2 = new User("schrotha", "82", "Adam", "Schroth", "sljf@msu.edu", uRole2);
		uDao.insert(u1);
		uDao.insert(u2);
		
		Reimbursement r1 = new Reimbursement("200", "Hotel Motel Holiday Inn", u1, rType1, rStat1);
		Reimbursement r2 = new Reimbursement("150", "Heading out California way", u1, rType2, rStat1);
		Reimbursement r3 = new Reimbursement("32", "Client dinner at Taco Bell", u1, rType3, rStat1);
		rDao.insert(r1);
		rDao.insert(r2);
		rDao.insert(r3);
	}
	
}
