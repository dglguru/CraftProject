package com.intuit.craftproject.exception;

/*
 * Exception for driver does not exists into system
 */
public class AlreadyExistException extends Exception{

	public AlreadyExistException(String message) {
		super (message);
	}

}
