package com.Bankexample.Bank.Service;

public class ResourceNotFoundException extends RuntimeException{
	public ResourceNotFoundException(String message) {
        super(message);
	}

}
