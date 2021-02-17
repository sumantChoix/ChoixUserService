package com.Choix.UserService.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Choix.UserService.Entity.Customer;
import com.Choix.UserService.Entity.Vendor;
import com.Choix.UserService.Repo.CustomerRepo;
import com.Choix.UserService.Repo.VendorRepo;


@Service
public class VendorService {

	@Autowired
	public VendorRepo vendorRepo;
	
	public List<Vendor> findAll(){
     return vendorRepo.findAll();	
	}

	public void saveVendor(Vendor vendor) {
		// TODO Auto-generated method stub
		vendorRepo.save(vendor);	
	}
	
	public Vendor singleVendor(int id1) {
		int id = id1;
		return vendorRepo.findById(id).orElse(null); 
	}
	
	
	
}
