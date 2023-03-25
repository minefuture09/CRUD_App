package com.springboot.customerDemo.exceptions;

public class CustomerPhoneNotFound extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2249843307656437005L;
	
	public CustomerPhoneNotFound(String msg)
	 {
	  super(msg);
	 }
	

}
