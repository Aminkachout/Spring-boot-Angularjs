package org.sid.web;

import java.util.ArrayList;
import java.util.List;

import org.sid.dao.ConsultationReposirory;
import org.sid.entities.Consultation;
import org.sid.entities.Medecin;
import org.sid.entities.Patient;
import org.sid.entities.RDV;
import org.sid.service.ConsultationServices;
import org.sid.service.MedecinService;
import org.sid.service.PatientService;
import org.sid.service.RDVServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsultationController {
	@Autowired 
	private MedecinService medecinService;
	@Autowired 
	private RDVServices rDVservice;
	@Autowired 
private ConsultationServices consultationservice;
	@Autowired
	private PatientService patientService;
	@Autowired
	private ConsultationReposirory consultation;
	@GetMapping("/GetConsultation")
	private List<Consultation> getConsultation1()
	{
		//return consultation.findAll();
		return consultationservice.getConsultation();
	}
	
	@PostMapping("/addConsultation")
	private void addConsultation(@RequestBody Consultation cons)
	{
		consultationservice.addConsultation(cons);
		
		rDVservice.deleteRdv(rDVservice.findUserByNom(cons.getUsernamepatient()));
		//patientService.findUserByUsername(cons.getUsernamepatient());
		//Long id = patientService.findUserByUsername(cons.getUsernamepatient()).getId();
		//System.out.println("this is id ****************************"+id);
		
		//rDVservice.deleterdvid(id);
		
		
	}
	@GetMapping("/getconsultationpatient")
	private List<Consultation>  getpatientconsultation(@RequestParam String usernamepatient)
	{	 List<Consultation> list =new ArrayList<Consultation>();
	Patient pat	= patientService.findUserByUsername(usernamepatient);
	list= consultationservice.findUserByUsernamepatient(usernamepatient);
	for (Consultation consultation : list) {
		consultation.setNompat(pat.getNom());
		consultation.setPrenompat(pat.getPrenom());
		consultation.setNommed(medecinService.findUserByUsername(consultation.getUsernamemedecin()).getNom());
		//consultation.setPrenommed(medecinService.findUserByUsername(consultation.getUsernamemedecin()).getPrenom());
		consultation.setPrenommed(medecinService.findUserByUsername(consultation.getUsernamemedecin()).getPrenom());
	}
	
	
	//Medecin med = medecinService.findUserByUsername()
	
	return list;
	//return consultationservice.findUserByUsernamepatient(usernamepatient);
		
	}
}
