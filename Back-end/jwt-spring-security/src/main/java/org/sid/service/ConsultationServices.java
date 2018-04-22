package org.sid.service;

import java.util.List;

import org.sid.entities.Consultation;

public interface ConsultationServices {
	public List<Consultation> getConsultation();
	//public List<Consultation> getUserconsultation(String usernamepatient);
	public List<Consultation>  findUserByUsernamepatient(String usernamepatient);
	public void addConsultation (Consultation cons) ;

}
