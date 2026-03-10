package com.mca.placement.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mca.placement.model.Admin;
import com.mca.placement.repository.AdminRepository;

@Service

public class AdminService {
 
    
    @Autowired
    private AdminRepository repo;

    public boolean login(String username,String password){

        Admin admin = repo.findByUsernameAndPassword(username,password);

        if(admin != null){
            return true;
        }

        return false;
    }
}
