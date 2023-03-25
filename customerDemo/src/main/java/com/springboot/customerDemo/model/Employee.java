package com.springboot.customerDemo.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class Employee {

	@Size(min = 3, message = "name atleast contain 3 chars")
	@NotNull
	private String ename;
	
	@Id
	 @GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int eid;
	@Pattern(regexp = "(^$|[0-9]{10})", message = "Please Enter Valid Phone Number")
	private String ephone;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "dp_id")
	private Department dept;

	public Employee() {
		super();
	}

	public Employee(@Size(min = 3, message = "name atleast contain 3 chars") @NotNull String ename, int eid,
			@Pattern(regexp = "(^$|[0-9]{10})", message = "Please Enter Valid Phone Number") String ephone) {
		super();
		this.ename = ename;
		this.eid = eid;
		this.ephone = ephone;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public String getEphone() {
		return ephone;
	}

	public void setEphone(String ephone) {
		this.ephone = ephone;
	}

	@Override
	public String toString() {
		return "Employee [ename=" + ename + ", eid=" + eid + ", ephone=" + ephone + "]";
	}
}
