package org.sid.service;

import java.util.List;

import org.sid.entities.Patient;
import org.springframework.data.domain.Page;

public interface PatientService {
	public Page<Patient> showPatient( int page);
	public Patient savePatient(Patient Pat);
	public void DeletPatient(Patient p);
	public List<Patient> listPat();
	public Patient Update(Patient pat ) ;
	public Patient findUserByUsername(String username);
}
