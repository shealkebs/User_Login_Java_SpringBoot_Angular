package com.springboot.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.app.model.UserLogin;

public interface UserLoginRepository extends JpaRepository<UserLogin, String>{



	List<UserLogin> getUserByUserName(String userName);

	

}
