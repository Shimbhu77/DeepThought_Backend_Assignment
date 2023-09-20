package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.exceptions.DoctorException;
import com.app.exceptions.PatientException;
import com.app.model.Doctor;
import com.app.model.Patient;
import com.app.model.PatientDTO;
import com.app.model.enums.City;
import com.app.model.enums.Speciality;
import com.app.model.enums.Symptom;
import com.app.repository.DoctorRepository;
import com.app.repository.PatientRepository;

@Service
public class PatientServiceImpl implements PatientService {

	@Autowired
	private PatientRepository patientRepository;

	@Autowired
	private DoctorRepository doctorRepository;

	// adding a new patient on the platform

	@Override
	public Patient addPatient(PatientDTO patientDetails) throws PatientException {

		Patient value = patientRepository.findByEmail(patientDetails.getEmail());

		if (value != null) {
			throw new PatientException("patient is already exists with this email : " + patientDetails.getEmail());
		}

		Patient patient = new Patient();

		patient.setName(patientDetails.getName());
		patient.setEmail(patientDetails.getEmail());
		patient.setPhoneNumber(patientDetails.getPhoneNumber());
		patient.setCity(patientDetails.getCity().toUpperCase());

		Symptom symptom = Symptom.valueOf(patientDetails.getSymptom().toUpperCase());

		patient.setSymptom(symptom);

		return patientRepository.save(patient);

	}

	// removing a patient from the platform

	@Override
	public String removePatient(Integer patientId) throws PatientException {

		Optional<Patient> optPatient = patientRepository.findById(patientId);

		if (optPatient.isPresent()) {
			Patient patient = optPatient.get();

			patientRepository.delete(patient);

			return "Patient removed successfully with this id : " + patientId;
		}
		throw new PatientException("no patient found with this id : " + patientId);
	}

	// suggesting doctors to the patient based on their symptom and location

	@Override
	public List<Doctor> suggestDoctor(Integer patientId) throws PatientException, DoctorException {

		Optional<Patient> optPatient = patientRepository.findById(patientId);

		if (optPatient.isPresent()) {
			Patient patient = optPatient.get();

			Symptom symptom = patient.getSymptom();

			Speciality speciality = symptom.getAssociatedSpeciality();

			String location = patient.getCity();

			if (location.equals("DELHI") || location.equals("NOIDA") || location.equals("FARIDABAD")) {
				City city = City.valueOf(patient.getCity());

				List<Doctor> doctorsList = doctorRepository.findBySpecialityAndCity(speciality, city);

				if (doctorsList.size() == 0) {
					throw new DoctorException("There isn’t any doctor present at your location for your symptom");
				}

				return doctorsList;

			}

			throw new DoctorException("We are still waiting to expand to your location");

		}
		throw new PatientException("no patient found with this id : " + patientId);
	}

	@Override
	public Patient findPatientById(Integer patientId) throws PatientException {
		
		Optional<Patient> optPatient = patientRepository.findById(patientId);

		if (optPatient.isPresent()) {
			
			Patient patient = optPatient.get();

			return patient;
		}
		throw new PatientException("no patient found with this id : " + patientId);
	}

	@Override
	public List<Patient> findAllPatients() throws PatientException {
		
		List<Patient> patients = patientRepository.findAll();
		
		if(patients.size()==0)
		{
			throw new PatientException("No patients are listed and List is Empty.");
		}
		
		return patients;
	}

}
