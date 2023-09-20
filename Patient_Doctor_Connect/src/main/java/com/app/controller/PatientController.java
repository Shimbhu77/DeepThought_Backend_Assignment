package com.app.controller;

import java.util.List;

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
import com.app.exceptions.PatientException;
import com.app.model.Doctor;
import com.app.model.Patient;
import com.app.model.PatientDTO;
import com.app.service.PatientService;


@RestController
@RequestMapping("/app/patients")
public class PatientController {

	@Autowired
	private PatientService patientService;
	
	// REST API for adding a new patient on the platform
	
	@PostMapping("/add")
	public ResponseEntity<Patient> addPatientHandler(@RequestBody PatientDTO patientDetails) throws  PatientException
	{
		Patient patient = patientService.addPatient(patientDetails);
		
		return new ResponseEntity<Patient>(patient,HttpStatus.CREATED);
	}
	
	
	// REST API for removing a patient from the platform
	
	@DeleteMapping("/{patientId}")
	public ResponseEntity<String> removePatientHandler(@PathVariable Integer patientId) throws PatientException
	{
		String message = patientService.removePatient(patientId);
		
		return new ResponseEntity<String>(message,HttpStatus.ACCEPTED);
	}
	
	
	// REST API for suggesting doctors to the patient based on their symptom and location 
	
	@GetMapping("/suggest-doctor/{patientId}")
	public ResponseEntity<List<Doctor>> suggestDoctorHandler(@PathVariable Integer patientId) throws PatientException, DoctorException
	{
		List<Doctor> doctorsList = patientService.suggestDoctor(patientId);
		
		return new ResponseEntity<List<Doctor>>(doctorsList,HttpStatus.ACCEPTED);
	}
	
	// REST API for finding a patient from the platform
	
	@GetMapping("/{patientId}")
	public ResponseEntity<Patient> findPatientByIdHandler(@PathVariable Integer patientId) throws PatientException
	{
		Patient patient = patientService.findPatientById(patientId);
		
		return new ResponseEntity<Patient>(patient,HttpStatus.ACCEPTED);
	}
	
	// REST API for find all patients from the platform
	
	@GetMapping("/all")
	public ResponseEntity<List<Patient>> findAllPatientsHandler() throws PatientException
	{
		List<Patient> patients = patientService.findAllPatients();
		
		return new ResponseEntity<List<Patient>>(patients,HttpStatus.ACCEPTED);
	}
		
	
	
}
