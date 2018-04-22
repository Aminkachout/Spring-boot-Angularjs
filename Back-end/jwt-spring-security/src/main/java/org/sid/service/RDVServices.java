package org.sid.service;
import java.util.List;

import org.sid.entities.RDV;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface RDVServices {

	public Page<RDV> getRDV(int page);
	//public void DeleteRDV(Long id);
	//public List<RDV> findUserByidmedecin(Long id);
	public List<RDV> findUserByUsernamemed(String med);
	public RDV addRDV(RDV rdv);
	public void deleteRdv(RDV rdv );
	public void deleterdvid(Long id);
	public RDV findUserByNom(String pat);
}
