package com.jwt.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	@Column(name = "username")
	String name;
	@Column(name = "password")
	String password;
	@Column(name = "email",unique = true)
	String email;
	@Column(name = "role")
	String role;
	@Column(name = "active")
	boolean isActive;
	
	public User() {}
	public User(int id, String name, String password, String role, boolean isActive,String email) {
		super();
		this.email = email;
		this.id = id;
		this.name = name;
		this.password = password;
		this.role = role;
		this.isActive = isActive;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = true;
	}

	
	
	

}
