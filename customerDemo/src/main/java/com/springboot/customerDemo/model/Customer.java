package com.springboot.customerDemo.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Customer_Table")
public class Customer {

	@Size(min = 3, message = "name atleast contain 3 chars")
	@NotNull
	private String cname;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int cid;

	private String email;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "aid")
	private Address address;
	


    @OneToMany(mappedBy = "customer")
	List<CustomerOrders> orders;

	public List<CustomerOrders> getOrders() {
		return orders;
	}

	public void setOrders(List<CustomerOrders> orders) {
		this.orders = orders;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Pattern(regexp = "(^$|[0-9]{10})", message = "Please Enter Valid Phone Number")
	private String cphone;

	public Customer() {
		super();
	}

	public Customer(@Size(min = 3, message = "name atleast contain 3 chars") @NotNull String cname, int cid,
			String email, Address address, List<CustomerOrders> orders,
			@Pattern(regexp = "(^$|[0-9]{10})", message = "Please Enter Valid Phone Number") String cphone) {
		super();
		this.cname = cname;
		this.cid = cid;
		this.email = email;
		this.address = address;
		this.orders = orders;
		this.cphone = cphone;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getCphone() {
		return cphone;
	}

	public void setCphone(String cphone) {
		this.cphone = cphone;
	}

	@Override
	public String toString() {
		return "Customer [cname=" + cname + ", cid=" + cid + ", email=" + email + ", address=" + address + ", orders="
				+ orders + ", cphone=" + cphone + "]";
	}

}