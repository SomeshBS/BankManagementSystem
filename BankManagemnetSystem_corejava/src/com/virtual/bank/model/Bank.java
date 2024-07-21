package com.virtual.bank.model;

import com.virtual.bank.custexception.AccountNotFoundException;
import com.virtual.bank.custexception.InsufficientBalenceException;

public abstract class Bank {
	public static final String BANKNAME="Virtual Bank";
	public static final String BANKADDRESS="Virtual Bank, 101, 2nd floor, Square Mall, city road, Pune - 411511";
	public static final String IFSCCODE="VBSS0000S";
	

	
	
	public abstract void creatAccount();
	public abstract void depositAmount();
	public abstract void withdrawAmount() throws InsufficientBalenceException, AccountNotFoundException;
	public abstract void checkBalence();
	public abstract User findCustomerByAccountNumber(long accountNumber) throws AccountNotFoundException;
	
}
