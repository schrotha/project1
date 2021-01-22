package com.project.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import io.javalin.http.Handler;

@Entity
@Table(name="Reimbursement")
public class Reimbursement {

	@Id
	@Column(name="r_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int rId;
	
	@Column(name="amount")
	private String amount;
	
	@Column(name="submitted")
	private String submitted;
	
	@Column(name="resolved")
	private String resolved;
	
	@Column(name="description")
	private String description;
	
	@Column(name="type")
	private String type;
	
	@Column(name="status")
	private String status;
	
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name="User_FK")
	private User owningUser;
	
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name="Type_FK")
	private ReimbursementType rType;
	
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name="Status_FK")
	private ReimburesementStatus rStat;
	
	public Reimbursement() {
		// TODO Auto-generated constructor stub
	}

	public Reimbursement(String amount, String description, User user, ReimbursementType rType, ReimburesementStatus rStat) {
		super();
		this.amount = amount;
		LocalDateTime date = LocalDateTime.now();
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		this.submitted = date.format(format);
		this.resolved = "Not Resolved";
		this.description = description;
		this.owningUser = user;
		this.rType = rType;
		this.type = rType.getReimType();
		this.rStat = rStat;
		this.status = rStat.getReimStatus();
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getSubmitted() {
		return submitted;
	}

	public String getResolved() {
		return resolved;
	}

	public void setResolved() {
		LocalDateTime date = LocalDateTime.now();
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		this.resolved = date.format(format);
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public User getUser() {
		return this.owningUser;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
		LocalDateTime date = LocalDateTime.now();
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		this.resolved = date.format(format);
	}

	public int getrId() {
		return rId;
	}

	public void setrId(int rId) {
		this.rId = rId;
	}

	@Override
	public String toString() {
		return "Reimbursement [id=" + rId + "amount=" + amount + ", submitted=" + submitted + ", resolved=" + resolved
				+ ", description=" + description + ", type=" + type + ", status=" + status + "]";
	}


	
}
