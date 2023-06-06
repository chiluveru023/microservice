package com.Bankexample.BankCustomer.Repsoitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Bankexample.BankCustomer.Model.CustomerModel;
@Repository
public interface CustomerRepository extends JpaRepository<CustomerModel, String>{
  public CustomerModel  findByPhoneNumber(String phoneNumber);
  
}
