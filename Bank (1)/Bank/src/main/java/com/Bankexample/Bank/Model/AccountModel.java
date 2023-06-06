package com.Bankexample.Bank.Model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(name="Account")
public class AccountModel {
	
	@Id
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	private String accountId;
	private String accountType;
	private String branch;
	private String customerId;
    private char minorIndicator;
	
	public AccountModel(String accountType, String branch, String customerId, char minorIndicator) {
		super();
		this.accountType = accountType;
		this.branch = branch;
		this.customerId = customerId;
		this.minorIndicator = minorIndicator;
	}


	
    
    
    public AccountModel() {
		super();
		// TODO Auto-generated constructor stub
	}


	public AccountModel(String accountId, String accountType, String branch, String customerId, char minorIndicator) {
		super();
		this.accountId = accountId;
		this.accountType = accountType;
		this.branch = branch;
		this.customerId = customerId;
		this.minorIndicator = minorIndicator;
	}


	public String getAccountId() {
		return accountId;
	}


	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}


	public String getAccountType() {
		return accountType;
	}


	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}


	public String getBranch() {
		return branch;
	}


	public void setBranch(String branch) {
		this.branch = branch;
	}


	public String getCustomerId() {
		return customerId;
	}


	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}


	public char getMinorIndicator() {
		return minorIndicator;
	}


	public void setMinorIndicator(char minorIndicator) {
		this.minorIndicator = minorIndicator;
	}


	@Override
	public String toString() {
		return "AccountModel [accountId=" + accountId + ", accountType=" + accountType + ", branch=" + branch
				+ ", customerId=" + customerId + ", minorIndicator=" + minorIndicator + "]";
	}


	

	
    
}