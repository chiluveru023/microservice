package com.Bankexample.Bank.exception;

public class AccountUpdateException extends Exception {

	private static final long serialVersionUID = 1L;

	public AccountUpdateException(String message) {
		super(message);
	}
}