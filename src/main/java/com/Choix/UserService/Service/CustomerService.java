package com.Choix.UserService.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Choix.UserService.Entity.Customer;
import com.Choix.UserService.Repo.CustomerRepo;


@Service
public class CustomerService {

	@Autowired
	public CustomerRepo customerRepo;
	
	public List<Customer> findAll(){
     return customerRepo.findAll();	
	}

	public void saveCustomer(Customer customer) {
	customerRepo.save(customer);
	
	}
	
	public Customer Singlecustomer(int id1) {
		int id = id1;
		return customerRepo.findById(id).orElse(null);
	}
	
	
	
}
