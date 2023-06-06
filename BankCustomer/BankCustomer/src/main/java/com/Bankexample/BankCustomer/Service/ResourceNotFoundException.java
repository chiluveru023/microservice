package com.Bankexample.BankCustomer.Service;

public class ResourceNotFoundException extends RuntimeException{
	public ResourceNotFoundException(String message) {
        super(message);
	}
}
