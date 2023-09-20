package com.app.exceptions;

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

	@ExceptionHandler(PatientException.class)
	public ResponseEntity<ErrorDetails> myExceptionHandler(PatientException e, WebRequest req) {
		ErrorDetails err = new ErrorDetails();
		err.setDescription(req.getDescription(false));
		err.setTimestamp(LocalDateTime.now());
		err.setMessage(e.getMessage());

		return new ResponseEntity<ErrorDetails>(err, HttpStatus.BAD_REQUEST);

	}

	@ExceptionHandler(DoctorException.class)
	public ResponseEntity<ErrorDetails> myExceptionHandler(DoctorException e, WebRequest req) {
		ErrorDetails err = new ErrorDetails();
		err.setDescription(req.getDescription(false));
		err.setTimestamp(LocalDateTime.now());
		err.setMessage(e.getMessage());

		return new ResponseEntity<ErrorDetails>(err, HttpStatus.BAD_REQUEST);

	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorDetails> myExceptionHandler(MethodArgumentNotValidException e) {
		ErrorDetails err = new ErrorDetails();
		err.setDescription("getting Error");
		err.setTimestamp(LocalDateTime.now());
		err.setMessage(e.getFieldError().getDefaultMessage());

		return new ResponseEntity<ErrorDetails>(err, HttpStatus.BAD_REQUEST);

	}

	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<ErrorDetails> handleConstraintViolationException(ConstraintViolationException ex) {
		String errorMessages = "";
		for (ConstraintViolation<?> violation : ex.getConstraintViolations()) {
			errorMessages += violation.getMessage() + " . ";
		}

		ErrorDetails errorDetails = new ErrorDetails();
		errorDetails.setDescription("Validation failed");
		errorDetails.setTimestamp(LocalDateTime.now());
		errorDetails.setMessage("Validation error : " + errorMessages);

		return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
	}


	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<ErrorDetails> myExceptionHandler(IllegalArgumentException e) {
		ErrorDetails err = new ErrorDetails();
		err.setDescription("exception occurs ");
		err.setTimestamp(LocalDateTime.now());
		
		if(e.getMessage().contains("City"))
		{
			err.setMessage(" Doctor's City name should be Delhi,Noida and Faridabad.");
		}
		else if(e.getMessage().contains("Speciality"))
		{
			err.setMessage(" Doctor speciality should be DERMATOLOGY, ENT, GYNECOLOGY, ORTHOPEDIC");
		}
		else if(e.getMessage().contains("Symptom"))
		{
			err.setMessage(" Patient Symptom's should be ARTHRITIS,BACK_PAIN,DYSMENORRHEA,EAR_PAIN,SKIN_BURN,SKIN_INFECTION,TISSUE_INJURIES");
		}
		else
		{
			err.setMessage(e.getMessage());
		}
		
		

		return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
	}
}
