package com.project.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="User")
public class User {
	
	@Id
	@Column(name="user_name")
	private String username;
	
	@Column(name="password")
	private String password;
	
	@Column(name="first_name")
	private String fName;
	
	@Column(name="last_name")
	private String lName;
	
	@Column(name="email")
	private String email;
	
	@OneToMany(mappedBy="owningUser", fetch=FetchType.LAZY)
	private List<Reimbursement> rList = new ArrayList<>();
	
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name="Role_FK")
	private UserRole role;
	
	public User() {
		// TODO Auto-generated constructor stub
	}

	
	public User(String username, String password, String fName, String lName, String email, UserRole role) {
		super();
		this.username = username;
		this.password = password;
		this.fName = fName;
		this.lName = lName;
		this.email = email;
		this.role = role;
	}



	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getRole() {
		return this.role.getRole();
	}
	
	public List<Reimbursement> getReimbursements(){
		return this.rList;
	}
	
	public void addReimbursement(Reimbursement r) {
		this.rList.add(r);
		System.out.println("in add");
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", fName=" + fName + ", lName=" + lName
				+ ", email=" + email + "]";
	}
	
	
	
}
