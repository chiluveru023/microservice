package com.Bankexample.Bank.Request;

import java.time.LocalDate;

public class AccountRequest {
	
	private String accountId;
	private String accountType;
	private String branch;
	private String customerId;
   private char minorIndicator;
   
   
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
   


}
