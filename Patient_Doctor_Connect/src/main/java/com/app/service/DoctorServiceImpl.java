package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.exceptions.DoctorException;
import com.app.model.Doctor;
import com.app.model.DoctorDTO;
import com.app.model.enums.City;
import com.app.model.enums.Speciality;
import com.app.repository.DoctorRepository;

@Service
public class DoctorServiceImpl implements DoctorService{

	@Autowired
	private DoctorRepository doctorRepository;
	
	
	// adding a new doctor on the platform
	
	@Override
	public Doctor addDoctor(DoctorDTO doctorDetails) throws DoctorException {
		

		    Doctor value = doctorRepository.findByEmail(doctorDetails.getEmail());
		    
		    if(value!=null)
		    {
		    	throw new DoctorException("Doctor is already exists with this email : "+doctorDetails.getEmail());
		    }
		
			Doctor doctor = new Doctor();
			
			doctor.setName(doctorDetails.getName());
			doctor.setEmail(doctorDetails.getEmail());
			doctor.setPhoneNumber(doctorDetails.getPhoneNumber());
			
			City city = City.valueOf(doctorDetails.getCity().toUpperCase());
			Speciality speciality = Speciality.valueOf(doctorDetails.getSpeciality().toUpperCase());
			
			doctor.setCity(city);
			doctor.setSpeciality(speciality);
			
			doctorRepository.save(doctor);
			
			return doctor;
		
	}

	// removing a doctor from the platform
	
	@Override
	public String removeDoctor(Integer doctorId) throws DoctorException {
		
		Optional<Doctor> optDoctor = doctorRepository.findById(doctorId);
		
		if(optDoctor.isPresent())
		{
			Doctor doctor = optDoctor.get();
			
			doctorRepository.delete(doctor);
			
			return "doctor removed successfully with this id : "+doctorId;
		}
		
		throw new DoctorException("no doctor is found with this doctor id : "+doctorId);
	}

	@Override
	public Doctor findDoctorById(Integer doctorId) throws DoctorException {
		

		Optional<Doctor> optDoctor = doctorRepository.findById(doctorId);
		
		if(optDoctor.isPresent())
		{
			Doctor doctor = optDoctor.get();
			
			return doctor;
		}
		
		throw new DoctorException("no doctor is found with this doctor id : "+doctorId);
	}

	@Override
	public List<Doctor> findAllDoctors() throws DoctorException {
		
		List<Doctor> doctorsList = doctorRepository.findAll();
		
		if(doctorsList.size()==0)
		{
			throw new DoctorException("List is Empty and No doctors are listed.");
		}
		
		return doctorsList;
	}

}
