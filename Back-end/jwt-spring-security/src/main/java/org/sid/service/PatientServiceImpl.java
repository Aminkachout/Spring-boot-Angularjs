package org.sid.service;

import java.util.List;

import org.sid.dao.PatientRepo;
import org.sid.dao.UserRepository;
import org.sid.entities.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
@Transactional
public class PatientServiceImpl implements PatientService{
	@Autowired 
	private PatientRepo patientRepo;
	@Autowired 
	private UserRepository userRepository;
	@Autowired
	private AccountService accountService;
	@Override
	public Page<Patient> showPatient(int page) {
		
		return patientRepo.findAll(new PageRequest(page, 5));
	}

	@Override
	public Patient savePatient(Patient Pat) {

		return patientRepo.save(Pat);
	}

	@Override
	public void DeletPatient(Patient pat) {

		patientRepo.delete(pat);
		//userRepository.delete(accountService.findUserByUsername(pat.getUsername()));
		
	}

	@Override
	public Patient Update(Patient pat) {
		
		return patientRepo.save(pat);
	}

	@Override
	public List<Patient> listPat() {
		// TODO Auto-generated method stub
		return patientRepo.findAll();
	}

	@Override
	public Patient findUserByUsername(String username) {
		return patientRepo.findUserByUsername(username);
	}

}
