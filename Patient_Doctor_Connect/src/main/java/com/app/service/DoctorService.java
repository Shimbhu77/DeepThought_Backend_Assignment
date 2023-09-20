package com.app.service;

import java.util.List;

import com.app.exceptions.DoctorException;
import com.app.model.Doctor;
import com.app.model.DoctorDTO;

public interface DoctorService {

	public Doctor addDoctor(DoctorDTO doctorDetails) throws DoctorException;
	public String removeDoctor(Integer doctorId) throws DoctorException;
	public Doctor findDoctorById(Integer doctorId) throws DoctorException;
	public List<Doctor> findAllDoctors() throws DoctorException;
	
}
