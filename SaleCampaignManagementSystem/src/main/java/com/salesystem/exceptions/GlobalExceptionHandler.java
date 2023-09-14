package com.salesystem.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;


import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(CampaignException.class)
	public ResponseEntity<ErrorDetails> myExceptionHandler(CampaignException pe , WebRequest req)
	{
		ErrorDetails err  = new ErrorDetails();
		err.setDescription(req.getDescription(false));
		err.setTimestamp(LocalDateTime.now());
		err.setMessage(pe.getMessage());
		
		return new ResponseEntity<ErrorDetails>(err,HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(ProductException.class)
	public ResponseEntity<ErrorDetails> myExceptionHandler(ProductException pe , WebRequest req)
	{
		ErrorDetails err  = new ErrorDetails();
		err.setDescription(req.getDescription(false));
		err.setTimestamp(LocalDateTime.now());
		err.setMessage(pe.getMessage());
		
		return new ResponseEntity<ErrorDetails>(err,HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<ErrorDetails> myExceptionHandler(ConstraintViolationException pe , WebRequest req)
	{
		String errorMessages = "";
        for (ConstraintViolation<?> violation : pe.getConstraintViolations()) {
            errorMessages+=violation.getMessage()+" . ";
        }

        ErrorDetails errorDetails = new ErrorDetails();
        errorDetails.setDescription("Validation failed");
        errorDetails.setTimestamp(LocalDateTime.now());
        errorDetails.setMessage("Validation error : "+errorMessages);

        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorDetails> myExceptionHandler(MethodArgumentNotValidException pe)
	{
		ErrorDetails err  = new ErrorDetails();
		err.setDescription("getting Error");
		err.setTimestamp(LocalDateTime.now());
		err.setMessage(pe.getFieldError().getDefaultMessage());
		
		return new ResponseEntity<ErrorDetails>(err,HttpStatus.BAD_REQUEST);
		
	}
}
