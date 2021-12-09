package com.springboot.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.app.model.PasswordChangeBackup;

public interface PasswordChangeRepository extends JpaRepository <PasswordChangeBackup, String>{

	List<PasswordChangeBackup> getUserByUserName(String userName);

}
