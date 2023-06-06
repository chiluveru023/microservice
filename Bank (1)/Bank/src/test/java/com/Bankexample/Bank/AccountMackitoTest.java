package com.Bankexample.Bank;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.Bankexample.Bank.Model.AccountModel;
import com.Bankexample.Bank.Repository.AccountRepository;
import com.Bankexample.Bank.Service.AccountService;



@SpringBootTest(classes= {AccountMackitoTest.class})
public class AccountMackitoTest {

	@Mock
    AccountRepository accountRepository;
	
	@InjectMocks
	AccountService accountService;
	
	public List<AccountModel> myaccounts;
	
	@Test
	@Order(1)
	public void test_getAllAccounts() {
		List<AccountModel> myaccounts = new ArrayList<AccountModel>();
		myaccounts.add(new AccountModel("1","Savings","Pune","1",'Y'));
		myaccounts.add(new AccountModel("2","Current","hyd","2",'N'));
		
		when(accountRepository.findAll()).thenReturn(myaccounts);//mocking statement
		assertEquals(2,accountService.getAllAccounts().size());
	}
	@Test
	@Order(2)
	public void test_deleteAccountById() {
		String accountId = "1";
		String result = accountService.deleteAccountById(accountId);
		verify(accountRepository,times(1)).deleteById(accountId);
		String expected = "Account with Id" + accountId + "has been deleted";
		assertEquals(expected,result);
		System.out.println("Expected: "+ expected);
		System.out.println("Actual: "+ result);
	}
}
