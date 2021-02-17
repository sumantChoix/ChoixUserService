package com.Choix.UserService.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Choix.UserService.Entity.Admin;

public interface AdminRepo extends JpaRepository<Admin, Integer>{

}
