package com.bankapp.bankapp.models;

import java.sql.Timestamp;

import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

public class ForgotPassword {

	@Id
	@NotNull
	private int uID;
	private int recoveryCode;
	private Timestamp lastDayUpdate;
	@OneToOne(mappedBy = "owner")
	private User user;
	public ForgotPassword() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ForgotPassword(@NotNull int uID, int recoveryCode, Timestamp lastDayUpdate, User user) {
		super();
		this.uID = uID;
		this.recoveryCode = recoveryCode;
		this.lastDayUpdate = lastDayUpdate;
		this.user = user;
	}
	@Override
	public String toString() {
		return "ForgotPassword [uID=" + uID + ", recoveryCode=" + recoveryCode + ", lastDayUpdate=" + lastDayUpdate
				+ ", user=" + user + "]";
	}
	public int getuID() {
		return uID;
	}
	public void setuID(int uID) {
		this.uID = uID;
	}
	public int getRecoveryCode() {
		return recoveryCode;
	}
	public void setRecoveryCode(int recoveryCode) {
		this.recoveryCode = recoveryCode;
	}
	public Timestamp getLastDayUpdate() {
		return lastDayUpdate;
	}
	public void setLastDayUpdate(Timestamp lastDayUpdate) {
		this.lastDayUpdate = lastDayUpdate;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	  
}
