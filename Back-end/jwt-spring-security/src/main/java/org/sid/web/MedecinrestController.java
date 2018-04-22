package org.sid.web;

import java.util.List;

import org.sid.dao.UserRepository;
import org.sid.entities.Medecin;
import org.sid.service.AccountService;
import org.sid.service.MedecinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MedecinrestController {
	@Autowired 
	 private UserRepository userRepository;
	 @Autowired
	 private AccountService  accountService;
	@Autowired
	private MedecinService medecinService ;
	@GetMapping("/getMed")
	private List<Medecin> getmedecin()
	{
		return  medecinService.getMedecinList();
	}
	@GetMapping("/listmedecin")
	private Page<Medecin> getMed(@RequestParam(defaultValue="0") int page)
	{
		return medecinService.showMedecin(page);
	}
	
	@GetMapping("/GetMedecin")
	private Medecin GetMedecin(@RequestParam String username)
	{
		return  medecinService.findUserByUsername(username);
	}
	@PostMapping("/addMedecin")
	private Medecin savemed(@RequestBody Medecin med)
	{
		return medecinService.saveMedecin(med);
	}
	
	@PutMapping("/update")
	private Medecin updatemed(@RequestBody Medecin med )
	{
		return medecinService.updatemed(med);
	}
	@PostMapping("/remove")
	private void deletemed(@RequestBody Medecin med)
	{
		medecinService.Deletemed(med);
		userRepository.delete(accountService.findUserByUsername(med.getUsername()));
		
	}
}
