package com.springboot.customerDemo.model;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
public class Department {
	@Size(min = 3, message = "name atleast contain 3 chars")
	@NotNull
	private String dp_name;
	@Id
	// @GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int dp_id;

	@ManyToOne(cascade = CascadeType.ALL)
	Employee employee;

	public Department() {
		super();
	}

	public Department(@Size(min = 3, message = "name atleast contain 3 chars") @NotNull String dp_name, int dp_id) {
		super();
		this.dp_name = dp_name;
		this.dp_id = dp_id;
	}

	public String getDp_name() {
		return dp_name;
	}

	public void setDp_name(String dp_name) {
		this.dp_name = dp_name;
	}

	public int getDp_id() {
		return dp_id;
	}

	public void setDp_id(int dp_id) {
		this.dp_id = dp_id;
	}

	@Override
	public String toString() {
		return "Employee [dp_name=" + dp_name + ", dp_id=" + dp_id + "]";
	}
}
