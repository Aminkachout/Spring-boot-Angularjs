package org.sid.dao;

import java.util.List;

import org.sid.entities.Consultation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultationReposirory extends JpaRepository<Consultation, Long> {
	
	public List<Consultation> findByUsernamepatient(String username);
	//public Consultation findById(Long id);


}
