package com.app.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Symptom {
	
    ARTHRITIS(Speciality.ORTHOPEDIC),
    BACK_PAIN(Speciality.ORTHOPEDIC),
    TISSUE_INJURIES(Speciality.ORTHOPEDIC),
    DYSMENORRHEA(Speciality.GYNECOLOGY),
    SKIN_INFECTION(Speciality.DERMATOLOGY),
    SKIN_BURN(Speciality.DERMATOLOGY),
    EAR_PAIN(Speciality.ENT);

    private Speciality associatedSpeciality;
    
    
}






