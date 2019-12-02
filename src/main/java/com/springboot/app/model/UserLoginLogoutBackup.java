package com.springboot.app.model;


import java.time.LocalDateTime;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class UserLoginLogoutBackup {

	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int srNo;
	private int userID;
	private String userName;
	private String userOldPassword;
	private String userNewPassword;
	private LocalDateTime passwordChangeDate;
	
	
	
	public UserLoginLogoutBackup() {
		super();
	}



	public UserLoginLogoutBackup(int srNo, int userID, String userName, String userOldPassword, String userNewPassword,
			LocalDateTime passwordChangeDate) {
		super();
		this.srNo = srNo;
		this.userID = userID;
		this.userName = userName;
		this.userOldPassword = userOldPassword;
		this.userNewPassword = userNewPassword;
		this.passwordChangeDate = passwordChangeDate;
	}



	public int getSrNo() {
		return srNo;
	}



	public void setSrNo(int srNo) {
		this.srNo = srNo;
	}



	public int getUserID() {
		return userID;
	}



	public void setUserID(int userID) {
		this.userID = userID;
	}



	public String getUserName() {
		return userName;
	}



	public void setUserName(String userName) {
		this.userName = userName;
	}



	public String getUserOldPassword() {
		return userOldPassword;
	}



	public void setUserOldPassword(String userOldPassword) {
		this.userOldPassword = userOldPassword;
	}



	public String getUserNewPassword() {
		return userNewPassword;
	}



	public void setUserNewPassword(String userNewPassword) {
		this.userNewPassword = userNewPassword;
	}



	public LocalDateTime getPasswordChangeDate() {
		return passwordChangeDate;
	}



	public void setPasswordChangeDate(LocalDateTime passwordChangeDate) {
		this.passwordChangeDate = passwordChangeDate;
	}



	@Override
	public String toString() {
		return "UserLoginLogoutBackup [srNo=" + srNo + ", userID=" + userID + ", userName=" + userName
				+ ", userOldPassword=" + userOldPassword + ", userNewPassword=" + userNewPassword
				+ ", passwordChangeDate=" + passwordChangeDate + "]";
	}
	
	
	
	
}
