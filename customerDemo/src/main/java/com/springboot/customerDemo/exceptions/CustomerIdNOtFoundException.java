package com.springboot.customerDemo.exceptions;

public class CustomerIdNOtFoundException  extends Exception{
	 
	 /**
	 * 
	 */
	private static final long serialVersionUID = -4977140485110087371L;

	public CustomerIdNOtFoundException(String msg)
	 {
	  super(msg);
	 }

}