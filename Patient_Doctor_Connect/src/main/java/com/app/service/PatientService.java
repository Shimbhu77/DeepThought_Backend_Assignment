package com.app.service;


import java.util.List;

import com.app.exceptions.DoctorException;
import com.app.exceptions.PatientException;
import com.app.model.Doctor;
import com.app.model.Patient;
import com.app.model.PatientDTO;

public interface PatientService {

	public Patient addPatient(PatientDTO patientDetails) throws PatientException;
	public Patient findPatientById(Integer patientId) throws PatientException;
	public List<Patient> findAllPatients() throws PatientException;
	public String removePatient(Integer patientId) throws PatientException;
	public List<Doctor> suggestDoctor(Integer patientId) throws PatientException,DoctorException;
}
