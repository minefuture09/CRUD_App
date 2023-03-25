package com.springboot.customerDemo.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;



@Entity
public class CustomerOrders {

	
	@Id
	private int ordId;
	private Date date;
	private String orders;
	

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="cid")
	private Customer customer;
	
	public CustomerOrders() {
		super();
	}

	public CustomerOrders(int ordId, Date date, String orders) {
		super();
		this.ordId = ordId;
		this.date = date;
		this.orders = orders;
	}

	public int getOrdId() {
		return ordId;
	}

	public void setOrdId(int ordId) {
		this.ordId = ordId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getOrders() {
		return orders;
	}

	public void setOrders(String orders) {
		this.orders = orders;
	}

	@Override
	public String toString() {
		return "Orders [ordId=" + ordId + ", date=" + date + ", orders=" + orders + "]";
	}
	
	
	
}
