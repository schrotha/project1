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
@Table(name="Reimbursement_Type")
public class ReimbursementType {
	
	@Id
	@Column(name="r_type")
	private String reimType;
	
	@OneToMany(mappedBy="rType", fetch=FetchType.LAZY)
	private List<Reimbursement> rList = new ArrayList<>();
	
	public ReimbursementType() {
		// TODO Auto-generated constructor stub
	}

	public ReimbursementType(String reimType) {
		super();
		this.reimType = reimType;
	}

	public String getReimType() {
		return this.reimType;
	}

	public void setReimType(String reimType) {
		this.reimType = reimType;
	}
	
	
}
