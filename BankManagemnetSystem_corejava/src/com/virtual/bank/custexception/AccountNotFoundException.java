package com.virtual.bank.custexception;

public class AccountNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7352008625878943966L;

	public AccountNotFoundException(String message) {
		super(message);
	}
	
}
