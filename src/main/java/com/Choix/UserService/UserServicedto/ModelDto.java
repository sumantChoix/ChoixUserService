package com.Choix.UserService.UserServicedto;

public class ModelDto {
	
	public String name;
	public String email;
	public String phoneNumber;
	public ModelDto(String name, String email, String phoneNumber) {
		super();
		this.name = name;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}
	@Override
	public String toString() {
		return "ModelDto [name=" + name + ", email=" + email + ", phoneNumber=" + phoneNumber + "]";
	}
	public ModelDto() {
		super();
		// TODO Auto-generated constructor stub
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
	
	
	
	
		

}
