package com.Bankexample.BankCustomer.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Bankexample.BankCustomer.Model.CustomerModel;
import com.Bankexample.BankCustomer.Request.CustomerRequest;
import com.Bankexample.BankCustomer.Service.CustomerService;



@RestController
@RequestMapping(value="/api")
public class CustomerController {

	@Autowired
	CustomerService customerService;
		
	@GetMapping("/customer/getAll")
		public ResponseEntity<List<CustomerModel>> getAllCustomers(){
			  List<CustomerModel> customer = customerService.getAllCustomers();
			  return ResponseEntity.ok(customer);
	}
//	@PostMapping("/customer")
//	public ResponseEntity<CustomerModel> createCustomer(@RequestBody CustomerModel customerModel){
//		CustomerModel savedCustomer = customerService.createCustomer(customerModel);
//		return new ResponseEntity<>(savedCustomer,HttpStatus.CREATED);
//		
//	}
	@PostMapping("/customer/create")
	public CustomerModel createCustomer(@RequestBody CustomerRequest customerRequest)
	{
		CustomerModel savedCustomer = new CustomerModel(customerRequest.getCustomerName()
				  ,customerRequest.getDateOfBirth(),customerRequest.getGender()
				   ,customerRequest.getPhoneNumber());
		
		return customerService.createCustomer(savedCustomer);
	}
	
	@GetMapping("/customer/{customerId}")
	public ResponseEntity<CustomerModel> getCustomerById(@PathVariable String customerId){
		CustomerModel customerModel = customerService.getById(customerId);
	   if(customerModel == null) {
		   return ResponseEntity.notFound().build();
	   }
	   else {
		   return ResponseEntity.ok(customerModel);
	   }
	  
	}
	

	 @PutMapping("/customer/{customerId}")
	   public ResponseEntity<CustomerModel> updateCustomer(@PathVariable String customerId,@RequestBody CustomerModel updatedCustomer){
		 CustomerModel savedcustomer = customerService.updateCustomer(customerId,updatedCustomer);
		 return ResponseEntity.ok(savedcustomer);
	 }
    @DeleteMapping("/customer/{customerId}")
     public ResponseEntity<String> deleteCustomerById(@PathVariable String customerId){
	  String message = customerService.deleteCustomerById(customerId);
	  return ResponseEntity.ok(message);
}
}


