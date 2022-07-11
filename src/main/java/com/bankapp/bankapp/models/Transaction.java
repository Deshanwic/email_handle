package com.bankapp.bankapp.models;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "transaction")
public class Transaction {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int tID;
	private int accNumber;
	private float amount;
	
	@Column(name = "date_Time")
	private Timestamp dateTime;
	
	
	private String type;
	private int destinationAccID;
	@ManyToOne
	@JsonIgnoreProperties("ownerAcc")
	@JoinColumn(name = "accNumber", insertable = false, updatable = false, nullable= false, referencedColumnName = "accNumber")
	private Account ownerAcc;
	public Transaction() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Transaction(int tID, int accNumber, float amount, Timestamp date_Time, String type, int destinationAccID,
			Account ownerAcc) {
		super();
		this.tID = tID;
		this.accNumber = accNumber;
		this.amount = amount;
		this.dateTime = date_Time;
		this.type = type;
		this.destinationAccID = destinationAccID;
		this.ownerAcc = ownerAcc;
	}
	@Override
	public String toString() {
		return "Transaction [tID=" + tID + ", accNumber=" + accNumber + ", amount=" + amount + ", date_Time="
				+ dateTime + ", type=" + type + ", destinationAccID=" + destinationAccID + ", ownerAcc=" + ownerAcc
				+ "]";
	}
	public int gettID() {
		return tID;
	}
	public void settID(int tID) {
		this.tID = tID;
	}
	public int getAccNumber() {
		return accNumber;
	}
	public void setAccNumber(int accNumber) {
		this.accNumber = accNumber;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	public Timestamp getDate_Time() {
		return dateTime;
	}
	public void setDate_Time(Timestamp date_Time) {
		this.dateTime = date_Time;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getDestinationAccID() {
		return destinationAccID;
	}
	public void setDestinationAccID(int destinationAccID) {
		this.destinationAccID = destinationAccID;
	}
	public Account getOwnerAcc() {
		return ownerAcc;
	}
	public void setOwnerAcc(Account ownerAcc) {
		this.ownerAcc = ownerAcc;
	}
	
	
	
		
}