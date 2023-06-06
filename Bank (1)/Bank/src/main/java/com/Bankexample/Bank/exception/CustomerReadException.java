package com.Bankexample.Bank.exception;

public class CustomerReadException extends Exception {

	private static final long serialVersionUID = 1L;

	public CustomerReadException(String message) {
		super(message);
	}
}