package com.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.app.model.Doctor;
import com.app.model.enums.City;
import com.app.model.enums.Speciality;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Integer> {
	
	Doctor findByEmail(String email);

	@Query("SELECT d FROM Doctor d WHERE d.speciality = :speciality AND d.city = :city")
    List<Doctor> findBySpecialityAndCity(@Param("speciality") Speciality speciality, @Param("city") City city);
}
