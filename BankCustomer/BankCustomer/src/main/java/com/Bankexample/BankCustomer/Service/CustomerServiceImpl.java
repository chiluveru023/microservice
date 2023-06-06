package com.Bankexample.BankCustomer.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Bankexample.BankCustomer.Model.CustomerModel;
import com.Bankexample.BankCustomer.Repsoitory.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService{
	@Autowired
	CustomerRepository customerRepository;
	
	@Override
	public List<CustomerModel> getAllCustomers(){
		return customerRepository.findAll();
	}

	@Override
	public CustomerModel createCustomer(CustomerModel customerModel) {
		
		return customerRepository.save(customerModel);
	}

	@Override
	public CustomerModel getById(String customerId) {
		return customerRepository.findById(customerId).orElse(null);
	}

	@Override
	public CustomerModel updateCustomer(String customerId, CustomerModel updatedCustomer) {
		CustomerModel customerModel = customerRepository.findById(customerId)
				.orElseThrow(() -> new ResourceNotFoundException("Customer not found with ID " + customerId));
		
		customerModel .setCustomerName(updatedCustomer.getCustomerName());
		customerModel .setDateOfBirth(updatedCustomer.getDateOfBirth());
		customerModel .setGender(updatedCustomer.getGender());
		customerModel .setPhoneNumber(updatedCustomer.getPhoneNumber());
		return customerRepository.save(customerModel);
	}

	@Override
	public String deleteCustomerById(String customerId) {
	customerRepository.deleteById(customerId);
		return  "Customer with Id" +  customerId  +  "has been deleted";
	}

//	public CustomerResponse createCustomer(CustomerRequest customerRequest) {
//	CustomerModel customerModel = new CustomerModel();
//		customerModel.setCustomerName(customerRequest.getCustomerName());
//		customerModel.setDateOfBirth(customerRequest.getDateOfBirth());
//		customerModel.setGender(customerRequest.getGender());
//		customerModel.setPhoneNumber(customerRequest.getPhoneNumber());
//		
//		customerRepository.save(customerModel);
//		return new CustomerResponse(customerModel);
//	}	
}
