package com.Choix.UserService.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class Customer  {

	
    @Id
    @GeneratedValue
	public int customerId;
    public String phone;
    public String name;
	
    
    
    
	@Override
	public String toString() {
		return "Customer [UserId=" + customerId + ", phone=" + phone + ", name=" + name + "]";
	}

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public int getUserId() {
		return customerId;
	}
	public void setUserId(int userId) {
		customerId = userId;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Customer(int userId, String phone, String name) {
		super();
		customerId = userId;
		this.phone = phone;
		this.name = name;
	}
    
    
	    
    
	
}
