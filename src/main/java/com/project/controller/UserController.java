package com.project.controller;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.internal.build.AllowSysOut;

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

import io.javalin.http.Handler;

public class UserController {

	private UserService uServ;
	private UserRoleService uRoleServ;
	private ReimbursementService rServ;
	private ReimbursementStatusService rStatServ;
	private ReimbursementTypeService rTypeServ;
	
	public UserController() {
		// TODO Auto-generated constructor stub
	}

	public UserController(UserService uServ, UserRoleService uRoleServ, ReimbursementService rServ, ReimbursementStatusService rStatServ, ReimbursementTypeService rTypeServ) {
		super();
		this.uServ = uServ;
		this.uRoleServ = uRoleServ;
		this.rServ = rServ;
		this.rStatServ = rStatServ;
		this.rTypeServ = rTypeServ;
	}
	
	public Handler postLogin = (ctx) ->{
	
		if(uServ.verifyPassword(ctx.formParam("username"), ctx.formParam("password"))) {
			ctx.sessionAttribute("user", uServ.getUser(ctx.formParam("username")));
			String role = uServ.getUserRole(ctx.formParam("username"));
			if(role.contentEquals("Employee")) {
				ctx.redirect("/html/employee.html");
			}
			else if(role.contentEquals("Finance Manager")) {
				ctx.redirect("/html/financemanager.html");
			}
		}
		else {
			ctx.redirect("/html/login.html");
		}
	};
	
	public Handler postCreateAccount = (ctx) ->{
		UserRole uRole = uRoleServ.selectByRole(ctx.formParam("role"));
		if(uRole == null) {
			ctx.redirect("/html/createuser.html");
		}
		else {
			if(uServ.createUser(uServ.getUserRole(ctx.formParam("username")), ctx.formParam("password"), ctx.formParam("fName"), ctx.formParam("lName"), ctx.formParam("email"), uRole)) {
				ctx.redirect("/html/login.html");
			}
			else {
				ctx.redirect("/html/createuser.html");
			}
		}
	};
	
	public Handler postCreateReimbursement = (ctx) ->{
		User u = (User)ctx.sessionAttribute("user");
		ReimbursementType rType = rTypeServ.selectByType(ctx.formParam("rType"));
		ReimburesementStatus rStat = rStatServ.selectByStatus("Pending");
		if(u == null || rType == null || rStat == null) {
			ctx.redirect("/html/createreimbursement.html");
		}
		else {
			rServ.createReimbursement(ctx.formParam("amount"), ctx.formParam("description"), u, rType, rStat);
			ctx.redirect("/html/employee.html");
		}
		
	};
	
	public Handler getSession = (ctx) ->{
		//ctx.json((User)ctx.sessionAttribute("user"));
		User u = (User)ctx.sessionAttribute("user");
		List<Reimbursement> rList = rServ.getReimbursementByUser(u);
		ctx.json(rList);
		
		
	};
	
	public Handler getPendingReimbursements = (ctx) ->{
		List<Reimbursement> rList = rServ.getPendingReimbursements();
		ctx.json(rList);
	};
	
	public Handler getHistoryReimbursements = (ctx) ->{
		List<Reimbursement> rList = rServ.getHistoryReimbursements();
		ctx.json(rList);
	};
	
	public Handler postResolveApprove = (ctx) ->{
		rServ.approveReimbursement(ctx.pathParam("id"));
		ctx.redirect("/html/SuccessfulPage.html");
	};
	
	public Handler postResolveDeny = (ctx) ->{
		rServ.denyReimbursement(ctx.pathParam("id"));
		ctx.redirect("/html/SuccessfulPage.html");
	};
	
	
}
