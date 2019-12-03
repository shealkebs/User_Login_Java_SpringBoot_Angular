package com.springboot.app.model;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;



@Entity
@Table(name="UserLogin")
public class UserLogin {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	
	@Column(unique = true)
	private String userName;
	
	private String userPassword;
	
	@Transient
	private String userNewPassword;
	
	@OneToMany(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	
	private List<PasswordChangeBackup> passwordChangeBackup;

	public UserLogin(int userId, String userName, String userPassword, String userNewPassword,
			List<PasswordChangeBackup> passwordChangeBackup) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userPassword = userPassword;
		this.userNewPassword = userNewPassword;
		this.passwordChangeBackup = passwordChangeBackup;
	}

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
	public List<PasswordChangeBackup> getPasswordChangeBackup() {
		return passwordChangeBackup;
	}

	public void setPasswordChangeBackup(List<PasswordChangeBackup> passwordChangeBackup) {
		this.passwordChangeBackup = passwordChangeBackup;
	}

	@Override
	public String toString() {
		return "UserLogin [userId=" + userId + ", userName=" + userName + ", userPassword=" + userPassword
				+ ", userNewPassword=" + userNewPassword + "]";
	}

	
		
}
