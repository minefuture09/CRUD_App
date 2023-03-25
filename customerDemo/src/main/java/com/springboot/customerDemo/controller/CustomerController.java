package com.springboot.customerDemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.springboot.customerDemo.exceptions.CustomerIdNOtFoundException;
import com.springboot.customerDemo.exceptions.CustomerNameNotFoundException;
import com.springboot.customerDemo.exceptions.CustomerPhoneNotFound;
import com.springboot.customerDemo.model.Customer;
import com.springboot.customerDemo.service.CustomerService;

@RestController
public class CustomerController {

	@Autowired
	CustomerService service;

	@GetMapping("/customers")
	public List<Customer> getAllCustomers() {
		return service.getAllCustomers();

	}

	@PostMapping("/customer")
	public Customer createCustomer(@RequestBody Customer customer) {
		return service.createCustomer(customer);
	}

	@DeleteMapping("/customer/{id}")
	public ResponseEntity<Customer> deleteCustomer(@PathVariable("id") int id) throws CustomerIdNOtFoundException {
		return service.deleteCustomer(id);

	}

	@PutMapping("/customer/{id}")
	public ResponseEntity<Customer> UpdateCustomer(@PathVariable("id") int id, @RequestBody Customer c)
			throws CustomerIdNOtFoundException {
		return service.updateCustomer(id, c);

	}

	@GetMapping("/customer/{id}")
	public ResponseEntity<Customer> getCustomer(@PathVariable("id") int id) throws CustomerIdNOtFoundException {
		return service.getCustomer(id);

	}

	@GetMapping("/customer_phone/{phone}")
	public ResponseEntity<Customer> getCustomerByPhone(@PathVariable("phone") String phone)
			throws CustomerPhoneNotFound {
		return service.getCustomerByPhone(phone);

	}

	@GetMapping("/customer_phone/{phone}/{id}")
	public ResponseEntity<Customer> getCustomerByPhoneAndId(@PathVariable("phone") String phone,
			@PathVariable("id") int id) throws CustomerPhoneNotFound, CustomerIdNOtFoundException {
		return service.getCustomerByPhoneAndId(phone, id);

	}

	@GetMapping("/customer_name/{name}")
	public ResponseEntity<Customer> getCustomerByName(@PathVariable("name") String name)
			throws CustomerNameNotFoundException {

		return service.getCustomerByName(name);
	}

}