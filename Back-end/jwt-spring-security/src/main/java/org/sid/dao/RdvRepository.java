package org.sid.dao;

import java.util.List;

import org.sid.entities.RDV;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RdvRepository extends JpaRepository<RDV, Long> {
	
	//public List<RDV> findByIdmedecin(Long id );
	public List<RDV> findByUsernamemed (String medecin);
	public RDV findByNom(String patient);

}
