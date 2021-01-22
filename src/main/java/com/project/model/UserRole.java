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
@Table(name="User_Role")
public class UserRole {

	@Id
	@Column(name="user_role")
	private String role;
	
	@OneToMany(mappedBy="role", fetch=FetchType.LAZY)
	private List<User> uList = new ArrayList<>();
	
	
	public UserRole() {
		// TODO Auto-generated constructor stub
	}

	public UserRole(String role) {
		super();
		this.role = role;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "UserRole [role=" + role + "]";
	}
	
}
