package com.springboot.app.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.app.model.PasswordChangeBackup;
import com.springboot.app.model.UserLogin;
import com.springboot.app.repository.PasswordChangeRepository;
import com.springboot.app.repository.UserLoginRepository;
@Service
public class UserLoginService {

	@Autowired
	private UserLoginRepository userLoginRepository;
	@Autowired
	private PasswordChangeRepository changePasswordRepository;


	UserLogin userSuccess = new UserLogin();
	
	public List<UserLogin> getUserList() {
		
		return userLoginRepository.findAll();
	}


	public UserLogin insertUser(@Valid UserLogin userLogin) {
		
		return userLoginRepository.save(userLogin);
	}
// for Login User
	public UserLogin findUserByUserName (UserLogin userLogin){
		try {
				List<UserLogin> userList=userLoginRepository.getUserByUserName(userLogin.getUserName());
					for(UserLogin user:userList)
						{
							System.out.println("in forEach");
							if(user.getUserName().equals(userLogin.getUserName()) && user.getUserPassword().equals(userLogin.getUserPassword()) ) 
								{
									userSuccess.setUserName(userLogin.getUserName());
									userSuccess.setUserPassword(userLogin.getUserPassword());
									userSuccess.setUserId(user.getUserId());
									 return userSuccess;
								 }
						}
			}
		catch(Exception e)
			{
				System.out.println("User Not Found");
			}
		
		System.out.println("at the end");
		return null;
	}
	
	// Reset password by Update User

	public int updateUserByUserName( @Valid UserLogin userLogin) {
		try {
		List<UserLogin> userList=userLoginRepository.getUserByUserName(userLogin.getUserName() );
			for(UserLogin user:userList)
				{
					if(user.getUserName().equals(userLogin.getUserName()) && user.getUserPassword().equals(userLogin.getUserPassword()) ) 
						{
							if(userLogin.getUserNewPassword().length()>=5) {
								user.setUserPassword(userLogin.getUserNewPassword());
								userLoginRepository.save(user);
								PasswordChangeBackup changePass= new PasswordChangeBackup();
								changePass.setUserID(user.getUserId());
								changePass.setUserName(user.getUserName());
								changePass.setUserOldPassword(userLogin.getUserPassword());
								changePass.setUserNewPassword(userLogin.getUserNewPassword());
								changePasswordRepository.save(changePass);
								return 1;
							}
						}
				}
		 if(userList.isEmpty()) 
			 {
				return 0;
			 }
		}catch(NullPointerException e) {
			System.out.println("No records available");
		}
		 return -1;
	}

	// to validate from session
	public UserLogin getUserByUserName(String userName, String userpassword) {
		
		try {
		List<UserLogin> userList=userLoginRepository.getUserByUserName(userName);
		for(UserLogin user:userList)
			{
				System.out.println("in forEach by get");
				if(user.getUserName().equals(userName) && user.getUserPassword() .equals(userpassword) ) 
					{
						userSuccess.setUserName(userName);
						userSuccess.setUserPassword(userpassword);
						userSuccess.setUserId(user.getUserId());
						return userSuccess;
					}
			}
		}
		catch(NullPointerException e) {
			System.out.println("No records available");
		}
		 return null;
	}
}
