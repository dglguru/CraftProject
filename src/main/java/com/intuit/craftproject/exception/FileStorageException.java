package com.intuit.craftproject.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

/*
 * Exception for driver does not exists into system
 */
public class FileStorageException extends Exception{

	public FileStorageException(String message) {
		super (message);
	}

}
