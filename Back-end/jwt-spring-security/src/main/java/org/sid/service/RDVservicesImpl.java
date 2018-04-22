package org.sid.service;

import java.util.List;

import org.sid.dao.RdvRepository;
import org.sid.entities.RDV;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
@Transactional
public class RDVservicesImpl implements RDVServices {
	@Autowired 
	private RdvRepository rdvRepository;
	@Override
	public Page<RDV> getRDV(int page) {
		// TODO Auto-generated method stub
		return rdvRepository.findAll(new PageRequest(page, 5)) ;
	}

	

	/*@Override
	public List<RDV> findUserByidmedecin(Long id) {
		return rdvRepository.findByIdmedecin(id);
		
	}
*/
	@Override
	public RDV addRDV(RDV rdv) {
		return rdvRepository.save(rdv);
	}

	@Override
	public List<RDV> findUserByUsernamemed(String med) {
		return rdvRepository.findByUsernamemed(med);
		
	}

	@Override
	public void deleteRdv(RDV rdv) {
		// TODO Auto-generated method stub
		rdvRepository.delete(rdv);
	}



	@Override
	public void deleterdvid(Long id) {
		rdvRepository.delete(id);
		
	}



	@Override
	public RDV findUserByNom(String pat) {
		return rdvRepository.findByNom(pat);
	}

	

	

}
