package com.Bankexample.BankCustomer;



import static org.hamcrest.CoreMatchers.any;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.Bankexample.BankCustomer.Model.CustomerModel;
import com.Bankexample.BankCustomer.Repsoitory.CustomerRepository;
import com.Bankexample.BankCustomer.Request.CustomerRequest;
import com.Bankexample.BankCustomer.Service.CustomerService;
import com.Bankexample.BankCustomer.Service.CustomerServiceImpl;

@SpringBootTest(classes= {ServiceMackitoTests.class})
public class ServiceMackitoTests {

	
	@Mock
	CustomerRepository customerRepository;
	
	@InjectMocks
	CustomerServiceImpl customerService;
	
	public List<CustomerModel> mycustomers;
	
	@Test
	@Order(1)
	public void test_getAllCustomers() {
		List<CustomerModel> mycustomers = new ArrayList<CustomerModel>();
		mycustomers.add(new CustomerModel("1","Siri",LocalDate.of(1998, 03, 14),'F',"9234561879"));
		mycustomers.add(new CustomerModel("2","Shivam",LocalDate.of(1994, 02, 21),'M',"9367561921"));
		
		when(customerRepository.findAll()).thenReturn(mycustomers);//mocking statement
		assertEquals(2,customerService.getAllCustomers().size());
	}
	
	@Test
	@Order(2)
	public void test_getById() {
		String customerId="1";
		CustomerModel mycustomers = new CustomerModel(customerId,"John",LocalDate.of(1999, 9, 25),'M',"1234555790");
		when(customerRepository.findById(customerId)).thenReturn(Optional.of(mycustomers));
		CustomerModel result = customerService.getById(customerId);
		verify(customerRepository,times(1)).findById(customerId);
		assertNotNull(result);
		assertEquals(mycustomers.getCustomerId(), result.getCustomerId());
		assertEquals(mycustomers.getCustomerName(),result.getCustomerName());
	}

	
	@Test
	@Order(3)
	public void test_CreateCustomer() {
		CustomerModel mycustomers = new CustomerModel("4","Joe",LocalDate.of(1996, 8, 24),'M',"9254555791");
		mycustomers.setCustomerId("2");
		mycustomers.setCustomerName("joo");
		mycustomers.setDateOfBirth(LocalDate.parse("1998-10-11"));
		mycustomers.setGender('M');
		mycustomers.setPhoneNumber("8796685412");
		when(customerRepository.save(mycustomers)).thenReturn(mycustomers);
		CustomerModel createdCustomer = customerService.createCustomer(mycustomers);
		verify(customerRepository,times(1)).save(mycustomers);
		assertNotNull(createdCustomer);
		assertEquals("2",createdCustomer.getCustomerId());
		assertEquals("joo",createdCustomer.getCustomerName());
		assertEquals(LocalDate.parse("1998-10-11"),createdCustomer.getDateOfBirth());
		assertEquals('M',createdCustomer.getGender());
		assertEquals("8796685412",createdCustomer.getPhoneNumber());
		
	}
//	
	@Test
	@Order(4)
	public void test_deleteCustomerById() {
		String customerId = "1";
		String result = customerService.deleteCustomerById(customerId);
		verify(customerRepository,times(1)).deleteById(customerId);
		String expected = "Customer with Id" + customerId + "has been deleted";
		assertEquals(expected,result);
		System.out.println("Expected: "+ expected);
		System.out.println("Actual: "+ result);
	}
	
	@Test
	@Order(5)
	public void test_updateCustomer(){
		CustomerModel mycustomers = new CustomerModel();
		mycustomers.setCustomerId("2");
		mycustomers.setCustomerName("joo");
		mycustomers.setDateOfBirth(LocalDate.parse("1998-10-11"));
		mycustomers.setGender('M');
		mycustomers.setPhoneNumber("8796685412");
		
		CustomerModel updatedcustomers = new CustomerModel();
		updatedcustomers.setCustomerId("2");
		updatedcustomers.setCustomerName("harry potter");
		updatedcustomers.setDateOfBirth(LocalDate.parse("1998-10-11"));
		updatedcustomers.setGender('M');
		updatedcustomers.setPhoneNumber("8796685412");
		when(customerRepository.findById("2")).thenReturn(Optional.of(mycustomers));
		when(customerRepository.save(mycustomers)).thenReturn(mycustomers);
		
		CustomerModel result = customerService.updateCustomer("2", updatedcustomers);
		assertEquals(updatedcustomers.getCustomerName(),result.getCustomerName());
		assertEquals(updatedcustomers.getDateOfBirth(),result.getDateOfBirth());
		assertEquals(updatedcustomers.getGender(),result.getGender());
		assertEquals(updatedcustomers.getPhoneNumber(),result.getPhoneNumber());
		
		verify(customerRepository).findById("2");
		verify(customerRepository).save(mycustomers);
	}

}
