package com.Bankexample.Bank.exception;

public class AccountCreateException extends Exception {

	private static final long serialVersionUID = 1L;

	public AccountCreateException(String message) {
		super(message);
	}
}