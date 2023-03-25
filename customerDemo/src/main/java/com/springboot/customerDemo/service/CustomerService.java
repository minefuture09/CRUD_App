package com.springboot.customerDemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.springboot.customerDemo.exceptions.CustomerIdNOtFoundException;
import com.springboot.customerDemo.exceptions.CustomerNameNotFoundException;
import com.springboot.customerDemo.exceptions.CustomerPhoneNotFound;
import com.springboot.customerDemo.model.Customer;
import com.springboot.customerDemo.repository.ICustomerRepostory;

@Service
public class CustomerService {
 
 @Autowired
 ICustomerRepostory repository;

 public List<Customer> getAllCustomers() {
  return repository.findAll();
 }

 public Customer createCustomer(Customer customer) {
  return  (Customer) repository.save(customer);
 }

public ResponseEntity<Customer> getCustomer(int id)throws CustomerIdNOtFoundException {

	Customer c = repository.findById(id).orElseThrow(()-> new CustomerIdNOtFoundException("Respective Id is Not Present "+id));
	return ResponseEntity.ok().body(c);
}

public ResponseEntity<Customer> deleteCustomer(int id)throws CustomerIdNOtFoundException {
	
	Customer c  = repository.findById(id).orElseThrow(()-> new CustomerIdNOtFoundException("Id "+id+" is not present so can't delete it!"));
	Customer c1 = c;
	repository.delete(c);
	return ResponseEntity.ok().body(c1);
	
}

public ResponseEntity<Customer> updateCustomer(int id,Customer c)throws CustomerIdNOtFoundException {
	
	Customer c1 = repository.findById(id).orElseThrow(()-> new CustomerIdNOtFoundException("Id "+id+" is not present so can't update it!"));
	c1=c;
	repository.save(c1);
	return ResponseEntity.ok().body(c1);
	}

public ResponseEntity<Customer> getCustomerByPhone(String phone)throws CustomerPhoneNotFound {

	Customer c = repository.findByPhone(phone).orElseThrow(()-> new CustomerPhoneNotFound("Respective Phone is Not Present "+phone));
	return ResponseEntity.ok().body(c);
}

public ResponseEntity<Customer> getCustomerByPhoneAndId(String phone,int id)throws CustomerPhoneNotFound,CustomerIdNOtFoundException {

	Customer c = repository.findByPhoneAndId(phone,id).orElseThrow(()-> new CustomerPhoneNotFound("Respective Id Or Phone is Not Present "+phone+" "+id));
	return ResponseEntity.ok().body(c);
}

public ResponseEntity<Customer>getCustomerByName(String name)throws CustomerNameNotFoundException{
	
	Customer c = repository.findByName(name).orElseThrow(()->new CustomerNameNotFoundException("Name Not Present"+name));
	return ResponseEntity.ok().body(c);
}

}