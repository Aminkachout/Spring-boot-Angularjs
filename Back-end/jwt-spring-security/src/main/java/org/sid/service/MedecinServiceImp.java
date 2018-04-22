package org.sid.service;

import java.util.List;

import org.sid.dao.MedecinRepo;
import org.sid.entities.Medecin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
@Transactional
public class MedecinServiceImp implements MedecinService {

	@Autowired
	private MedecinRepo medecinRepo;
	@Override
	public Medecin saveMedecin(Medecin med) {
		
		return medecinRepo.save(med);
	}

	@Override
	public List<Medecin> getMedecinList() {
		// TODO Auto-generated method stub
		return medecinRepo.findAll();
	}

	@Override
	public Medecin findUserByUsername(String username) {
		
		return medecinRepo.findUserByUsername(username);
	}

	
	@Override
	public Page<Medecin> showMedecin(int page) {
		
		return medecinRepo.findAll(new PageRequest(page, 5));
	}

	@Override
	public Medecin updatemed(Medecin med) {
		
		return medecinRepo.save(med);
	}

	@Override
	public void Deletemed(Medecin med) {
		medecinRepo.delete(med);
	}

}
