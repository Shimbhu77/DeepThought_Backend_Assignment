package com.app.controller;

import java.util.List;

import javax.print.Doc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.exceptions.DoctorException;
import com.app.model.Doctor;
import com.app.model.DoctorDTO;
import com.app.service.DoctorService;


@RestController
@RequestMapping("/app/doctors")
public class DoctorController {

	@Autowired
	private DoctorService doctorService;
	
	// REST API for adding a new doctor on the platform
	
	@PostMapping("/add")
	public ResponseEntity<Doctor> addDoctorHandler(@RequestBody DoctorDTO doctorDetails) throws DoctorException
	{
		Doctor doctor = doctorService.addDoctor(doctorDetails);
		
		return new ResponseEntity<Doctor>(doctor,HttpStatus.CREATED);
	}
	
	// REST API for removing a doctor from the platform
	
	@DeleteMapping("/{doctorId}")
	public ResponseEntity<String> removeDoctorHandler(@PathVariable Integer doctorId) throws DoctorException
	{
		String message = doctorService.removeDoctor(doctorId);
		
		return new ResponseEntity<String>(message,HttpStatus.ACCEPTED);
	}
	
	// REST API for finding a doctor from the platform
	
	@GetMapping("/{doctorId}")
	public ResponseEntity<Doctor> findDoctorByIdHandler(@PathVariable Integer doctorId) throws DoctorException
	{
		Doctor doctor = doctorService.findDoctorById(doctorId);
		
		return new ResponseEntity<Doctor>(doctor,HttpStatus.ACCEPTED);
	}
	
	// REST API for find all doctors from the platform
	
	@GetMapping("/all")
	public ResponseEntity<List<Doctor>> findAllDoctorsHandler() throws DoctorException
	{
		List<Doctor> doctors = doctorService.findAllDoctors();
		
		return new ResponseEntity<List<Doctor>>(doctors,HttpStatus.ACCEPTED);
	}
	
	
}
