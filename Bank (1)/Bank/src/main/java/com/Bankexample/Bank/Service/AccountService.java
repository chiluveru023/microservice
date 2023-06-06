package com.Bankexample.Bank.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.Bankexample.Bank.Model.AccountModel;
import com.Bankexample.Bank.Repository.AccountRepository;
import com.Bankexample.Bank.Request.AccountRequest;
import com.Bankexample.Bank.Response.AccountResponse;
import com.Bankexample.Bank.Response.CustomerResponse;
import com.Bankexample.Bank.exception.AccountCreateException;

import reactor.core.publisher.Mono;

@Service
public class AccountService  {




	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private WebClient webClient;

	public AccountResponse createAccount(AccountRequest accountRequest) throws AccountCreateException {
		
		if(accountRequest.getCustomerId() != null) {
			AccountModel account = new AccountModel();
			account.setAccountType(accountRequest.getAccountType());
			account.setBranch(accountRequest.getBranch());
			account.setCustomerId(accountRequest.getCustomerId());
			account.setMinorIndicator(accountRequest.getMinorIndicator());
			AccountResponse accountResponse = new AccountResponse();
			accountResponse.setAccountModel(account);
			accountResponse.setCustomerResponse(getCustomerById(account.getCustomerId()));
			accountRepository.save(account);
			return accountResponse;
		}

		else {
			throw new AccountCreateException("Customer not exsist. Please Do Register First");
		}
		
		
	}

	public List<AccountModel> getAllAccounts() {
		return accountRepository.findAll();
	}

	public AccountResponse getById(String accountId) {
		AccountModel account = accountRepository.findById(accountId).get();
		AccountResponse accountResponse = new AccountResponse();
		accountResponse.setAccountModel(account);
		accountResponse.setCustomerResponse(getCustomerById(account.getCustomerId()));
		return accountResponse;
	}

	public CustomerResponse getCustomerById(String customerId) {
		Mono<CustomerResponse> customerResponse = webClient.get().uri("/customer/" + customerId).retrieve()
				.bodyToMono(CustomerResponse.class);
		return customerResponse.block();
	}

	
		public String deleteAccountById(String accountId) {
			accountRepository.deleteById(accountId);
				return  "Account with Id" +  accountId  +  "has been deleted";
			}
	

}
