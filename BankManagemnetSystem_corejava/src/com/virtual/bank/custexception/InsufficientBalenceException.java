package com.virtual.bank.custexception;

public class InsufficientBalenceException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4081539248662214045L;

	public InsufficientBalenceException(String message) {
		super(message);
	}
}
