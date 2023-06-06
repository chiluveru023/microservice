package com.Bankexample.Bank.Response;

import java.time.LocalDate;

public class CustomerResponse {
	
	private String customerId;
	private String customerName;
	private LocalDate dateOfBirth;
	private char gender;
	private String phoneNumber;
	
//	public CustomerResponse(String customerId, String customerName, LocalDate dateOfBirth, char gender,
//			String phoneNumber) {
//		super();
//		this.customerId = customerId;
//		this.customerName = customerName;
//		this.dateOfBirth = dateOfBirth;
//		this.gender = gender;
//		this.phoneNumber = phoneNumber;
//	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
}
