package com.intuit.craftproject.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ControllerAdviceImpl extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(NoSuchDriverException.class)
	public ResponseEntity<ErrorMessage> handleNoSuchDriverException(Exception ex, WebRequest request){
		
		ErrorMessage message = new ErrorMessage(
		        HttpStatus.BAD_REQUEST.value(),
		        new Date(),
		        ex.getMessage(),
		        request.getDescription(false));
		return new ResponseEntity<>(message,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(AlreadyExistException.class)
	public ResponseEntity<ErrorMessage> handleAlreadyExistException(Exception ex, WebRequest request){
		
		ErrorMessage message = new ErrorMessage(
		        HttpStatus.BAD_REQUEST.value(),
		        new Date(),
		        ex.getMessage(),
		        request.getDescription(false));
		return new ResponseEntity<>(message,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(PhoneNumberAlreadyExistsException.class)
	public ResponseEntity<ErrorMessage> handlePhoneNumberAlreadyExistsException(Exception ex, WebRequest request){
		
		ErrorMessage message = new ErrorMessage(
		        HttpStatus.BAD_REQUEST.value(),
		        new Date(),
		        ex.getMessage(),
		        request.getDescription(false));
		return new ResponseEntity<>(message,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(FileStorageException.class)
	public ResponseEntity<ErrorMessage> handleFileStorageException(Exception ex, WebRequest request){
		
		ErrorMessage message = new ErrorMessage(
		        HttpStatus.BAD_REQUEST.value(),
		        new Date(),
		        ex.getMessage(),
		        request.getDescription(false));
		return new ResponseEntity<>(message,HttpStatus.BAD_REQUEST);
	}


}
