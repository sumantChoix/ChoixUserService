package com.Choix.UserService.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Choix.UserService.Entity.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Integer>{

}
