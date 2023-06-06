package com.Bankexample.Bank.Response;

import java.time.LocalDate;

import com.Bankexample.Bank.Model.AccountModel;

public class AccountResponse {
	
	
	private CustomerResponse customerResponse;
   
    private AccountModel accountModel;

	public AccountResponse(CustomerResponse customerResponse, AccountModel accountModel) {
		super();
		this.customerResponse = customerResponse;
		this.accountModel = accountModel;
	}
	

	public AccountResponse() {
		super();
		// TODO Auto-generated constructor stub
	}


	public CustomerResponse getCustomerResponse() {
		return customerResponse;
	}

	public void setCustomerResponse(CustomerResponse customerResponse) {
		this.customerResponse = customerResponse;
	}

	public AccountModel getAccountModel() {
		return accountModel;
	}

	public void setAccountModel(AccountModel accountModel) {
		this.accountModel = accountModel;
	}
	
	
	

}
