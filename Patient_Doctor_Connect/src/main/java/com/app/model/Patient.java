package com.app.model;

import com.app.model.enums.Symptom;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Patient {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer patientId;
	
	@Size(min=3,message = "name should have at least 3 characters.")
	private String name;
	
	@Size(max=20,message = "city should have maximum 20 characters.")
	private String city;
	
	@Email(message = "enter a valid email.")
	private String email;
	
	@Size(min=10,message = "phone nummber should have at least 10 numbers.")
	private String phoneNumber;
	
	@Enumerated(EnumType.STRING)
	private Symptom symptom;
}
