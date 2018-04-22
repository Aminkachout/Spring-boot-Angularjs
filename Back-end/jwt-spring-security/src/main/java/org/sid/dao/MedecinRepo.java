package org.sid.dao;

import java.util.List;

import org.sid.entities.Medecin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedecinRepo extends JpaRepository<Medecin, Long> {
	public Medecin findUserByUsername(String username);
	
	


}
