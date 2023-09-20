package com.app.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PatientDTO {

	@Size(min=3,message = "name should have at least 3 characters.")
	private String name;
	
	@Size(max=20,message = "city should have maximum 20 characters.")
	private String city;
	
	@Email(message = "enter a valid email.")
	private String email;
	
	@Size(min=10,message = "phone nummber should have at least 10 numbers.")
	private String phoneNumber;
	
	@NotBlank(message = "enter symptom's of the patient which should be ARTHRITIS,BACK_PAIN,DYSMENORRHEA,EAR_PAIN,SKIN_BURN,SKIN_INFECTION,TISSUE_INJURIES")
	private String symptom;
}
