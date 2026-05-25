package com.curd.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.curd.model.Admin;

public interface AdminRepository
        extends JpaRepository<Admin, Long> {

    Admin findByEmail(String email);
}