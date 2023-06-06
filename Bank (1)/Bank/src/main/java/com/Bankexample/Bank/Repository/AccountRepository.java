package com.Bankexample.Bank.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Bankexample.Bank.Model.AccountModel;

public interface AccountRepository extends JpaRepository<AccountModel,String>{

}
