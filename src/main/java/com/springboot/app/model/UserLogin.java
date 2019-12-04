package com.springboot.app.model;



import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Size;





@Entity
@Table(name="UserLogin")
public class UserLogin {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	
	@Column(unique = true)
	@Size(min = 5, max = 15)
	private String userName;
	
	@Size(min = 5, max = 15)
	private String userPassword;
	
	@Transient
	@Size(min = 5, max = 15)
	private String userNewPassword;
	
	public UserLogin() {
		super();
	}

	public UserLogin(int userId, String userName, String userPassword, String userNewPassword) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userPassword = userPassword;
		this.userNewPassword = userNewPassword;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserNewPassword() {
		return userNewPassword;
	}

	public void setUserNewPassword(String userNewPassword) {
		this.userNewPassword = userNewPassword;
	}
	

	@Override
	public String toString() {
		return "UserLogin [userId=" + userId + ", userName=" + userName + "]";
	}

	
		
}
