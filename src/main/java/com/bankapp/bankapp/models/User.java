package com.bankapp.bankapp.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.UniqueElements;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int uID;
	@NotNull
	private String uFName;
	private String uLName;
	private String address;
	
	
	//@Email
	//@NotNull
//    @UniqueElements(message = "This email is already in the database")
//	@Column(name = "userEmail", unique = true)
	private String userEmail;
	private String password;
	private String userType;
	
	@OneToMany(mappedBy = "owner")
//	@JsonIgnoreProperties("owner")
	private List<Account> accounts;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(int uID, String uFName, String uLName, String uddress, String userEmail, String uassword,
			String userType, List<Account> accounts) {
		super();
		this.uID = uID;
		this.uFName = uFName;
		this.uLName = uLName;
		this.address = uddress;
		this.userEmail = userEmail;
		this.password = uassword;
		this.userType = userType;
		this.accounts = accounts;
	}
	
	






	

	@Override
	public String toString() {
		return "User [uID=" + uID + ", uFName=" + uFName + ", uLName=" + uLName + ", uddress=" + address
				+ ", userEmail=" + userEmail + ", uassword=" + password + ", userType=" + userType + ", accounts="
				+ accounts + "]";
	}








	public int getuID() {
		return uID;
	}








	public void setuID(int uID) {
		this.uID = uID;
	}








	public String getuFName() {
		return uFName;
	}








	public void setuFName(String uFName) {
		this.uFName = uFName;
	}








	public String getuLName() {
		return uLName;
	}








	public void setuLName(String uLName) {
		this.uLName = uLName;
	}








	public String getAddress() {
		return address;
	}








	public void setAddress(String uddress) {
		this.address = uddress;
	}








	public String getUserEmail() {
		return userEmail;
	}








	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}








	public String getPassword() {
		return password;
	}








	public void setPassword(String uassword) {
		this.password = uassword;
	}








	public String getUserType() {
		return userType;
	}








	public void setUserType(String userType) {
		this.userType = userType;
	}








	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}
	
	
}
