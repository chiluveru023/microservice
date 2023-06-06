package com.Bankexample.Bank.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Bankexample.Bank.Model.AccountModel;
import com.Bankexample.Bank.Request.AccountRequest;
import com.Bankexample.Bank.Response.AccountResponse;

import com.Bankexample.Bank.Service.AccountService;
import com.Bankexample.Bank.Service.AccountService;
import com.Bankexample.Bank.exception.AccountCreateException;


@RestController
@RequestMapping("/apis")
public class AccountController {

	@Autowired
	private AccountService accountService;

	@GetMapping("/account/{accountId}")
	public AccountResponse getAccountById(@RequestBody AccountRequest accountRequest) throws AccountCreateException {
		return accountService.createAccount(accountRequest);
	}
	

	@PostMapping("/account/create")
	public AccountResponse createAccount(@RequestBody AccountRequest accountRequest) throws AccountCreateException {
		return accountService.createAccount(accountRequest);
	}

	@GetMapping("/account/getAll")
	public ResponseEntity<List<AccountModel>> getAllAccounts() {
		List<AccountModel> account = accountService.getAllAccounts();
		return ResponseEntity.ok(account);
	}

	  @DeleteMapping("/account/{accountId}")
	     public ResponseEntity<String> deleteAccountById(@PathVariable String accountId){
		  String message = accountService.deleteAccountById(accountId);
		  return ResponseEntity.ok(message);
	}
}