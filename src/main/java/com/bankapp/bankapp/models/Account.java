package com.bankapp.bankapp.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "account")
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int accNumber;
	@ManyToOne
	@JoinColumn(name = "uID", insertable = false, updatable = false, nullable= false, referencedColumnName = "uID")
	@JsonIgnoreProperties("accounts")
	private User owner;
	@OneToMany(mappedBy = "ownerAcc")
	@JsonIgnoreProperties("ownerAcc")
	private List<Transaction> transactins;
//	@NotBlank(message = "User ID is mandatory!!!!!!!")
	private int uID;
//	@NotBlank(message = "Starting deposit is mandatory!!!!!!!")
	private float balance;
	private String cOD;
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Account(int accNumber, User owner, List<Transaction> transactins, int uID, float balance, String cOD) {
		super();
		this.accNumber = accNumber;
		this.owner = owner;
		this.transactins = transactins;
		this.uID = uID;
		this.balance = balance;
		this.cOD = cOD;
	}
	@Override
	public String toString() {
		return "Account [accNumber=" + accNumber + ", owner=" + owner + ", transactins=" + transactins + ", uID=" + uID
				+ ", balance=" + balance + ", cOD=" + cOD + "]";
	}
	public int getAccNumber() {
		return accNumber;
	}
	public void setAccNumber(int accNumber) {
		this.accNumber = accNumber;
	}
	public User getOwner() {
		return owner;
	}
	public void setOwner(User owner) {
		this.owner = owner;
	}
	public List<Transaction> getTransactins() {
		return transactins;
	}
	public void setTransactins(List<Transaction> transactins) {
		this.transactins = transactins;
	}
	public int getuID() {
		return uID;
	}
	public void setuID(int uID) {
		this.uID = uID;
	}
	public float getBalance() {
		return balance;
	}
	public void setBalance(float balance) {
		this.balance = balance;
	}
	public String getcOD() {
		return cOD;
	}
	public void setcOD(String cOD) {
		this.cOD = cOD;
	}
	
	
	
	
}
