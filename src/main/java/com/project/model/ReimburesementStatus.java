package com.project.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Reimburesement_Status")
public class ReimburesementStatus {
	
	@Id
	@Column(name="r_status")
	private String reimStatus;
	
	@OneToMany(mappedBy="rStat", fetch=FetchType.LAZY)
	private List<Reimbursement> rList = new ArrayList<>();
	
	public ReimburesementStatus() {
		// TODO Auto-generated constructor stub
	}

	public ReimburesementStatus(String reimStatus) {
		super();
		this.reimStatus = reimStatus;
	}

	public String getReimStatus() {
		return reimStatus;
	}

	public void setReimStatus(String reimStatus) {
		this.reimStatus = reimStatus;
	}

	@Override
	public String toString() {
		return "ReimburesementStatus [reimStatus=" + reimStatus + "]";
	}
	
	
	
}
