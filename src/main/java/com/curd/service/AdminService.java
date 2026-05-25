package com.curd.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curd.model.Admin;
import com.curd.repository.AdminRepository;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    public String login(Admin admin){

        Admin existingAdmin =
                adminRepository.findByEmail(
                        admin.getEmail()
                );

        if(existingAdmin != null
                &&
           existingAdmin.getPassword().equals(
                   admin.getPassword()
           )){

            return "Login Success";
        }

        return "Invalid Email or Password";
    }
}