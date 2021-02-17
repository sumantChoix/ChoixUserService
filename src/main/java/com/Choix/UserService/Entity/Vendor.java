package com.Choix.UserService.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Vendor {


	@Id
	@GeneratedValue
	public int Vendorid;

	public String phonenumber;

	@Override
	public String toString() {
		return "Vendor [Vendorid=" + Vendorid + ", phonenumber=" + phonenumber + "]";
	}

	public Vendor(int vendorid, String phonenumber) {
		super();
		Vendorid = vendorid;
		this.phonenumber = phonenumber;
	}

	public int getVendorid() {
		return Vendorid;
	}

	public void setVendorid(int vendorid) {
		Vendorid = vendorid;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public Vendor() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
