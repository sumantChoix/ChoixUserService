package com.Choix.UserService.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Choix.UserService.Entity.Admin;
import com.Choix.UserService.Entity.Customer;
import com.Choix.UserService.Entity.Vendor;
import com.Choix.UserService.Repo.AdminRepo;
import com.Choix.UserService.Repo.CustomerRepo;
import com.Choix.UserService.Repo.VendorRepo;


@Service
public class AdminService {

	@Autowired
	public AdminRepo adminRepo;
	
	public List<Admin> findAll(){
     return adminRepo.findAll();	
	}

	public void saveAdmin(Admin admin) {
	adminRepo.save(admin);
    }
	
	
	public Admin SingleAdmin(int id1) {
		int id = id1;
		return adminRepo.findById(id).orElse(null);
		
	} 
	
	
	
	
	
}
