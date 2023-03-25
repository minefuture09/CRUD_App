package com.springboot.customerDemo.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.springboot.customerDemo.model.Customer;

@Repository
public interface ICustomerRepostory extends JpaRepository<Customer,Integer>{

	@Query(value="select * from customer_table ct where ct.cphone=?",nativeQuery = true)
	Optional<Customer> findByPhone(@Param("phone") String phone);

	@Query(value="select ct from Customer ct where ct.cphone=:cphone and ct.cid=:cid")
	Optional<Customer> findByPhoneAndId(@Param("cphone") String phone,@Param("cid") int id);

	@Query(value="select ct from Customer ct where ct.cname=:cname")
	Optional<Customer> findByName(@Param("cname")String cname);

}