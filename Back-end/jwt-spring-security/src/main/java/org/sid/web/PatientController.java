package org.sid.web;

import java.util.List;

import org.sid.dao.UserRepository;
import org.sid.entities.Medecin;
import org.sid.entities.Patient;
import org.sid.service.AccountService;
import org.sid.service.PatientService;
import org.sid.service.PatientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PatientController {

@Autowired	
private PatientService patientService;
 @Autowired 
 private UserRepository userRepository;
 @Autowired
 private AccountService  accountService;
@GetMapping("/listpatient")
private List<Patient> getPatient()
	{
	return patientService.listPat();
	}

@GetMapping("/listPatient")
private Page<Patient> getPat(@RequestParam(defaultValue="0") int page)
	{
	return patientService.showPatient(page);
	}
	

@GetMapping("/GetPatient")
private Patient getPatient(@RequestParam String username)
{
	return patientService.findUserByUsername(username);
}
	@PostMapping("/addPatient")
	private Patient AddPatient(@RequestBody Patient pat)
	{
		return patientService.savePatient(pat);
	}
	
	@PutMapping("/updatePatient")
	private Patient updatePat(@RequestBody Patient pat)
	{
		return patientService.Update(pat);
	}
	@PostMapping("/deletePatient")
	private  void deletePat(@RequestBody Patient pat)
	{
		patientService.DeletPatient(pat);
		userRepository.delete(accountService.findUserByUsername(pat.getUsername()));
	}
	
}
