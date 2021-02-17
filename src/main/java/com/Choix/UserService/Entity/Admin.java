package com.Choix.UserService.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Admin  {


	@Id
	@GeneratedValue
	public int Adminid;
	public String name;
	public String email;
	public String phoneNumber;
	public int getAdminid() {
		return Adminid;
	}
	public void setAdminid(int adminid) {
		Adminid = adminid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	@Override
	public String toString() {
		return "Admin [Adminid=" + Adminid + ", name=" + name + ", email=" + email + ", phoneNumber=" + phoneNumber
				+ "]";
	}
	public Admin(int adminid, String name, String email, String phoneNumber) {
		super();
		Adminid = adminid;
		this.name = name;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}
	
		
	
	
	
	
}
