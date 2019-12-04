package com.springboot.app.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.app.model.PasswordChangeBackup;
import com.springboot.app.repository.PasswordChangeRepository;

@Service
public class PasswordChangeBackupService {

	@Autowired
	private PasswordChangeRepository changePasswordRepository;
	
	public List<PasswordChangeBackup> getUpdatedList() {
		return changePasswordRepository.findAll();
	}

	public PasswordChangeBackup insertChangePass(@Valid PasswordChangeBackup passwordChangeBackup) {
		return changePasswordRepository.save(passwordChangeBackup);
	}

	public List<PasswordChangeBackup> getPasswordChangeBackupList(String userName) {
		return changePasswordRepository.getUserByUserName(userName);
	}
}
