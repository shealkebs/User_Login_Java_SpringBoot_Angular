package com.springboot.app.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.app.model.PasswordChangeBackup;
import com.springboot.app.model.UserLogin;
import com.springboot.app.service.PasswordChangeBackupService;
import com.springboot.app.service.UserLoginService;




@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/api/UserLoginController")
public class UserLoginController {

	@Autowired
	private UserLoginService userLoginService;
	@Autowired
	private PasswordChangeBackupService passwordChangeBackupService;
	
	
	@GetMapping(value="/viewUsers")
	public List<PasswordChangeBackup> showAll(HttpSession session) {
		String u1=(String) session.getAttribute("userName");
		String u2=(String) session.getAttribute("userpassword");
		UserLogin uLogin=userLoginService.getUserByUserName(u1,u2);
		if(uLogin.getUserName() != null) {
		List<PasswordChangeBackup> list=passwordChangeBackupService.getPasswordChangeBackupList(u1);
		return  (list);
		}
		return null;
	}

	@PostMapping(value="/insertUser",headers="Accept=application/json")
	 public UserLogin insertUser(@Valid @RequestBody UserLogin userLogin){
		 return userLoginService.insertUser(userLogin);
	 }

	
	@PostMapping(value="/loginUser",headers="Accept=application/json")
	public UserLogin getUserByUserName(@Valid @RequestBody UserLogin userLogin, HttpSession session) 
	{
	
		UserLogin uLogin=userLoginService.findUserByUserName(userLogin);
		if(uLogin != null) {
			session.setAttribute("userName", userLogin.getUserName());
			session.setAttribute("userpassword", userLogin.getUserPassword());
			System.out.println(session.getAttribute("userName"));
			System.out.println(session.getAttribute("userpassword"));
			System.out.println("session attribute set");
			uLogin.setUserPassword("null");
			session.setMaxInactiveInterval(30);
			return  (uLogin);
		}
		return  (uLogin);	
	}
	
	
	@PutMapping(value="/updateUser",headers="Accept=application/json")
	public String updateUserByUserName(@Valid @RequestBody UserLogin userLogin) {
		int status=userLoginService.updateUserByUserName(userLogin);
		if(status==1) {
			return  "User password updated Successfully";
		}
		else if(status==0) {
			return  "Unable to update User Password as Username is Incorrect";
		}
		return  "Unable to update User Password as Old Password Dosent Match";
	}	
	
	@GetMapping(value="/viewUsers/{userName}/{userPassword}",headers="Accept=application/json")
	public UserLogin getUserByUserName(@PathVariable(value="userName") String userName,
			@PathVariable(value="userPassword") String userPassword) {
		UserLogin uLogin=userLoginService.getUserByUserName(userName,userPassword);		
	return  (uLogin);	
	}

	
	@PostMapping("/logoutUser")
	public String destroySession(HttpServletRequest request) {
		request.getSession().invalidate();
		return "Session Expired";
	}
	
	

}
	

