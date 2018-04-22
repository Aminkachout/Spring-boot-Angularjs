package org.sid.service;

import java.util.List;

import org.sid.entities.AppRole;
import org.sid.entities.AppUser;
import org.sid.entities.Medecin;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestParam;

public interface MedecinService {
	
	public Medecin saveMedecin(Medecin med);
	public List<Medecin> getMedecinList();
	public Page<Medecin> showMedecin( int page);
	public Medecin updatemed(Medecin med) ;
	
	
	public void Deletemed(Medecin med );
	//public List<Medecin>  findUserByUsername1(String username);
	public Medecin findUserByUsername(String username);

}
