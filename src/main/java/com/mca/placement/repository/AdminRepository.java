package com.mca.placement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.mca.placement.model.Admin;

public interface AdminRepository extends JpaRepository<Admin,Integer> {

    Admin findByUsernameAndPassword(String username, String password);

}