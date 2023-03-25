package com.springboot.customerDemo.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Address {

	@Id
	private int aid;
	private String city;
	private String state;
	private String zipcode;

	@OneToOne(mappedBy = "address")
	Customer customer;

	public Address() {
		super();

	}

	public Address(int aid, String city, String state, String zipcode, Customer customer) {
		super();
		this.aid = aid;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
		this.customer = customer;
	}

	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	@Override
	public String toString() {
		return "Address [aid=" + aid + ", city=" + city + ", state=" + state + ", zipcode=" + zipcode + "]";
	}

}
