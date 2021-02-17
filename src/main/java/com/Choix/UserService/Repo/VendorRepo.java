package com.Choix.UserService.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Choix.UserService.Entity.Vendor;

public interface VendorRepo extends JpaRepository<Vendor, Integer> {

}
