package com.springboot.app.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.app.model.PasswordChangeBackup;
import com.springboot.app.service.PasswordChangeBackupService;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/api/BackupController")
public class BackupController {

	@Autowired
	private PasswordChangeBackupService passwordChangeBackupService;
	
	@GetMapping(value="/UpdateLog")
	public List<PasswordChangeBackup>showUpdated() {
		System.out.println("Hii inside");
		List<PasswordChangeBackup> list=passwordChangeBackupService.getUpdatedList();
		return  (list);
	}
	
	@PostMapping(value="/changePassLog",headers="Accept=application/json")
	 public PasswordChangeBackup insertChangePass(@Valid @RequestBody PasswordChangeBackup passwordChangeBackup){
		 return passwordChangeBackupService.insertChangePass(passwordChangeBackup);
	 }
}
