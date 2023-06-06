package com.Bankexample.Bank.exception;

public class AccountReadException extends Exception {

	private static final long serialVersionUID = 1L;

	public AccountReadException(String message) {
		super(message);
	}
}