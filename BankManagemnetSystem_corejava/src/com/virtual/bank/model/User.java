package com.virtual.bank.model;

import com.virtual.bank.custexception.InsufficientBalenceException;

public class User {
	private int ssnNo;
	private String name, email, address, panNumber;
	private long contactNumber, accountNumber, adharNumber;
	private double balence;
	
	public User(int ssnNo, String name, String email, String address, String panNumber, long contactNumber,
			long accountNumber, long adharNumber, double balence) {
		super();
		this.ssnNo = ssnNo;
		this.name = name;
		this.email = email;
		this.address = address;
		this.panNumber = panNumber;
		this.contactNumber = contactNumber;
		this.accountNumber = accountNumber;
		this.adharNumber = adharNumber;
		this.balence = balence;
	}

	public int getSsnNo() {
		return ssnNo;
	}

	public void setSsnNo(int ssnNo) {
		this.ssnNo = ssnNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPanNumber() {
		return panNumber;
	}

	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}

	public long getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(long contactNumber) {
		this.contactNumber = contactNumber;
	}

	public long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public long getAdharNumber() {
		return adharNumber;
	}

	public void setAdharNumber(long adharNumber) {
		this.adharNumber = adharNumber;
	}

	public double getBalence() {
		return balence;
	}

	public void setBalence(double balence) {
		this.balence = balence;
	}
	
	
	
	@Override
	public String toString() {
		return "User [ssnNo=" + ssnNo + "\n name=" + name + ", email=" + email + ", address=" + address + ", panNumber="
				+ panNumber + ", contactNumber=" + contactNumber + ", accountNumber=" + accountNumber + ", adharNumber="
				+ adharNumber + ", balence=" + balence + "]";
	}

	public void deposit(double amount) {
		balence+=amount;
	}
	
	public boolean withdraw(double amount) throws InsufficientBalenceException {
		if(balence-amount<1000) {
			throw new InsufficientBalenceException("The minimum balence should be 1000");
		}else {
			balence-=amount;
			return true;
		}
	}
	
}
