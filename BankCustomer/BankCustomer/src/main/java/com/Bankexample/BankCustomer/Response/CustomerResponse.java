package com.Bankexample.BankCustomer.Response;

import java.time.LocalDate;

import com.Bankexample.BankCustomer.Model.CustomerModel;

public class CustomerResponse {
	
	private String customerId;
	private String customerName;
	private LocalDate dateOfBirth;
	private char gender;
	private String phoneNumber;
	
	public CustomerResponse(CustomerModel customerModel) {
		super();
		this.customerId = customerModel.getCustomerId();
		this.customerName = customerModel.getCustomerName();
		this.dateOfBirth = customerModel.getDateOfBirth();
		this.gender = customerModel.getGender();
		this.phoneNumber =customerModel.getPhoneNumber();
	}

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
