package com.springboot.app.model;



import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table
public class PasswordChangeBackup {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int srNo;
	private int userID;
	private String userName;
	private String userOldPassword;
	private String userNewPassword;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "passwordChangeDate", nullable = false, updatable=false)
	private Date passwordChangeDate;
	
	public PasswordChangeBackup() {
		super();
	}


	public PasswordChangeBackup(int srNo, int userID, String userName, String userOldPassword, String userNewPassword,
			Date passwordChangeDate) {
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


	public Date getPasswordChangeDate() {
		return passwordChangeDate;
	}


	public void setPasswordChangeDate(Date passwordChangeDate) {
		this.passwordChangeDate = passwordChangeDate;
	}


	@Override
	public String toString() {
		return "PasswordChangeBackup [srNo=" + srNo + ", userID=" + userID + ", userName=" + userName
				+ ", userOldPassword=" + userOldPassword + ", userNewPassword=" + userNewPassword
				+ ", passwordChangeDate=" + passwordChangeDate + "]";
	}	
	
}
