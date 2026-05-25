package com.curd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.curd.model.User;

public interface UserRepository extends JpaRepository<User, Long>{

	User findByPhone(String phone);
	User findByEmail(String email);
}
