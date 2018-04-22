package org.sid.service;

import java.util.List;

import org.sid.dao.ConsultationReposirory;
import org.sid.entities.Consultation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
@Transactional
public class ConsultationServicesImpl implements ConsultationServices {
@Autowired
private ConsultationReposirory consultationRepo;


@Override
	public List<Consultation> getConsultation() {
		// TODO Auto-generated method stub
		return consultationRepo.findAll();
	}

	/*@Override
	public List<Consultation> getUserconsultation(String usernamepatient) {
		
		return consultationRepo.findUserByUsernamepatient(usernamepatient);
	}*/

	@Override
	public void addConsultation(Consultation cons) {
		// TODO Auto-generated method stub
		consultationRepo.save(cons);
		
		
		
		
	}

	@Override
	public List<Consultation> findUserByUsernamepatient(String usernamepatient) {
		// TODO Auto-generated method stub
		return consultationRepo.findByUsernamepatient(usernamepatient);
	}
	

}
