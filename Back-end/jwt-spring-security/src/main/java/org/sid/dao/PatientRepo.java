package org.sid.dao;

import org.sid.entities.Medecin;
import org.sid.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepo extends JpaRepository<Patient, Long> {
	public Patient findUserByUsername(String username);
	//public Patient findById(String username);

}
