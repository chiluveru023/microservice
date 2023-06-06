package com.Bankexample.BankCustomer.Service;

import java.util.List;

import com.Bankexample.BankCustomer.Model.CustomerModel;

public interface CustomerService {

	List<CustomerModel> getAllCustomers();

	CustomerModel createCustomer(CustomerModel savedCustomer);

	CustomerModel getById(String customerId);

	CustomerModel updateCustomer(String customerId, CustomerModel updatedCustomer);

	String deleteCustomerById(String customerId);

}
