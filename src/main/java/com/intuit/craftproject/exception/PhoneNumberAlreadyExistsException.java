package com.intuit.craftproject.exception;

/*
 * Exception for new driver phone number already exists into system
 */
public class PhoneNumberAlreadyExistsException extends Exception{

	public PhoneNumberAlreadyExistsException(String message) {
		super (message);
	}

}
