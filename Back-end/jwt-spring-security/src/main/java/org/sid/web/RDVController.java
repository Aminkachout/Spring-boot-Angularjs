package org.sid.web;

import java.util.List;

import org.sid.entities.RDV;
import org.sid.service.RDVServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RestController

public class RDVController {
	
	
	@Autowired
	private RDVServices rdvServices;
	

	@DeleteMapping("/deleteRDVid")
	public void deleterdvid(@RequestParam Long id)
	{
		rdvServices.deleterdvid(id);
	}
	@PostMapping("/deleteRDV")
	public void deleterdv(@RequestBody RDV rdv)
	{
		rdvServices.deleteRdv(rdv);
	}
	@GetMapping("/listrdv")
	public Page<RDV> getrdv(@RequestParam(defaultValue="0") int page)
	{
		return rdvServices.getRDV(page);
	}
	
	@GetMapping("/listpatrdv")
	public List<RDV> getrdvpat(@RequestParam String  username)
	{
		return rdvServices.findUserByUsernamemed(username);
	}
	
	@PostMapping("/addrdv")
	public RDV addrdv(@RequestBody RDV r)
	{
		return rdvServices.addRDV(r);
	}

}
