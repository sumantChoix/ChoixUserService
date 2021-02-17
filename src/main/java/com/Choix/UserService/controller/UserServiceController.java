package com.Choix.UserService.controller;




import java.util.List;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.Choix.UserService.Entity.Admin;
import com.Choix.UserService.Entity.Customer;
import com.Choix.UserService.Entity.Vendor;
import com.Choix.UserService.Service.AdminService;
import com.Choix.UserService.Service.CustomerService;
import com.Choix.UserService.Service.VendorService;
import com.Choix.UserService.UserServicedto.ModelDto;

@RestController
@RequestMapping("/user")
public class UserServiceController {

	@Autowired
	public AdminService adminService;
	
	@Autowired
	public CustomerService customerService;
	
	
	@Autowired
	public VendorService vendorService;
	
	
	@GetMapping("/")
	public String Home() {
		return "hello";
	}
	
	@GetMapping("/{userType}")
	@ResponseBody
	public JSONArray getAll(@PathVariable("userType") String userType){
		JSONArray arr = new JSONArray();
		if(userType.equals("admin")) {
		List<Admin> adminData=adminService.findAll();
		for(Admin admin:adminData){
		JSONObject obj = new JSONObject();
		obj.put("name",admin.getName());
		obj.put("phone",admin.getPhoneNumber());
		obj.put("email",admin.getEmail());
		obj.put("AdminId",admin.getAdminid());
		arr.add(obj);
	    }	
			
		}else if(userType.equals("customer")) {
		
		List<Customer> cusData=customerService.findAll();
		for(Customer cus:cusData) {
		JSONObject obj = new JSONObject();
		obj.put("name",cus.getName());
		obj.put("phone",cus.getPhone());
		obj.put("id",cus.getUserId());
	    arr.add(obj);
	    }
		}
		else if(userType.equals("vendor")) {
		List<Vendor> vend = vendorService.findAll();
		for(Vendor ven:vend) {
		JSONObject obj = new JSONObject();
		obj.put("phone",ven.getPhonenumber());
		obj.put("id",ven.getVendorid());
		arr.add(obj);
		}
		}
		return arr;
	}
	
	@PostMapping("/{userType}")
	public String saveObject(@PathVariable("userType") String userType,@RequestBody ModelDto modelDto) {
		String name = modelDto.getName();
		String phone=modelDto.getPhoneNumber();
		String email=modelDto.getEmail();
		
		
		if(userType.equals("admin")) {
			Admin admin = new Admin();
			admin.setEmail(email);
			admin.setName(name);
			admin.setPhoneNumber(phone);
			System.out.println(admin);
			adminService.saveAdmin(admin);
			
		}else if (userType.equals("customer")) {
        Customer cus = new Customer();
		cus.setName(name);
		cus.setPhone(phone);
		System.out.println(cus);
		customerService.saveCustomer(cus);
			
			
		}else if(userType.equals("vendor")) {
		  Vendor ven = new Vendor();
		  ven.setPhonenumber(phone);
		  System.out.println(ven);
		  vendorService.saveVendor(ven);
		}
		return userType;
		
	}
	
     @GetMapping("/{userType}/{id}")
	public JSONArray getByone(@PathVariable("userType") String userType ,@PathVariable("id") int id) {
		JSONArray arr = new JSONArray();
		int id1 =id; 
		Admin adminData=adminService.SingleAdmin(id1);
        if(userType.equals("admin")) {
			if(adminData==null) {
				String text="admin doesnot exit";
				JSONObject obj = new JSONObject();
				obj.put("error", text);
				arr.add(obj);
				}
			else {
			JSONObject obj = new JSONObject();
			obj.put("name",adminData.getName());
			obj.put("phone",adminData.getPhoneNumber());
			obj.put("email",adminData.getEmail());
			obj.put("AdminId",adminData.getAdminid());
			arr.add(obj);
		   }
		    
		}
        if(userType.equals("vendor")) {
			Vendor venData=vendorService.singleVendor(id1);
			if(venData==null) {
				String text="vendor doesnot exit";
				JSONObject obj = new JSONObject();
				obj.put("error", text);
				arr.add(obj);
				}else {
			JSONObject obj = new JSONObject();
			obj.put("phone",venData.getPhonenumber());
			obj.put("id",venData.getVendorid());
			arr.add(obj);
				}
		    		}
        if(userType.equals("customer")) {
			Customer cusData=customerService.Singlecustomer(id1);
			if(cusData==null) {
				String text="customer doesnot exit";
				JSONObject obj = new JSONObject();
				obj.put("error", text);
				arr.add(obj);
			}else {
			JSONObject obj = new JSONObject();
			obj.put("name",cusData.getName());
			obj.put("phone",cusData.getPhone());
			obj.put("id",cusData.getUserId());
		    arr.add(obj);
		    
			}
		}
		return arr;
	}
     @PutMapping("/{userType}/{id}")
     public String saveObject(@PathVariable("userType") String userType,@PathVariable("id") int id,@RequestBody ModelDto modelDto) {
    	JSONArray arr = new JSONArray();
    	String phoneNumber=modelDto.getPhoneNumber();
    	String Email=modelDto.getEmail();
    	String Name=modelDto.getName();
    	
    	System.out.println(phoneNumber+" "+Email+" "+Name);
    	
 		int modelDtoId =id;
 		
 		
    	if(userType.equals("vendor")) {
    		Vendor vendor=vendorService.singleVendor(modelDtoId);
    		if(vendor==null) {
    			String text=" vendor doesnit exit";
				userType=text;	
				System.out.print("in if block");
    		}else {
    			Vendor ven = new Vendor();
    			ven.setPhonenumber(phoneNumber);
    			ven.setVendorid(modelDtoId);
    			vendorService.saveVendor(ven);
    		}
    	}
    	if(userType.equals("customer")) {
    		Customer cus=customerService.Singlecustomer(modelDtoId);
    		if(cus==null) {
    			String text=" customer doesnit exit";
    			userType=text;
    		}else {
			Customer cus1=new Customer();
			cus1.setName(Name);
			cus1.setUserId(modelDtoId);
			cus1.setPhone(phoneNumber);
			customerService.saveCustomer(cus1);
		    }
    	}if(userType.equals("admin")) {
    		Admin admin = adminService.SingleAdmin(modelDtoId);
    		if(admin==null) {
    			String text=" customer doesnit exit";
    			userType=text;
    		}else {
    			Admin admin1=new Admin();
    			admin1.setAdminid(modelDtoId);
    			admin1.setName(Name);
    			admin1.setPhoneNumber(phoneNumber);
    			admin1.setEmail(Email);
    			adminService.saveAdmin(admin1);
    			
    		}
    	} 
 
    	
    	
    	
    	
		return "sucessfully  updated "+userType; 
     }
	
	
}
