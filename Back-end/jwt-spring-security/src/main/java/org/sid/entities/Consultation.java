package org.sid.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Consultation {
	@Id @GeneratedValue
	private long id ;
	@Temporal(TemporalType.DATE)
	private Date date ; 
	private String usernamepatient;
	private String usernamemedecin;
	private String nommed;
	private String prenommed;
	private String prenompat;
	private String nompat ;
	private String description ;
	public Consultation(Date date, String usernamepatient, String usernamemedecin, String nommed, String prenommed,
			String prenompat, String nompat, String description) {
		super();
		this.date = date;
		this.usernamepatient = usernamepatient;
		this.usernamemedecin = usernamemedecin;
		this.nommed = nommed;
		this.prenommed = prenommed;
		this.prenompat = prenompat;
		this.nompat = nompat;
		this.description = description;
		
	}
	public Consultation() {
		super();
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getUsernamepatient() {
		return usernamepatient;
	}
	public void setUsernamepatient(String usernamepatient) {
		this.usernamepatient = usernamepatient;
	}
	public String getUsernamemedecin() {
		return usernamemedecin;
	}
	public void setUsernamemedecin(String usernamemedecin) {
		this.usernamemedecin = usernamemedecin;
	}
	public String getNommed() {
		return nommed;
	}
	public void setNommed(String nommed) {
		this.nommed = nommed;
	}
	public String getPrenommed() {
		return prenommed;
	}
	public void setPrenommed(String prenommed) {
		this.prenommed = prenommed;
	}
	public String getPrenompat() {
		return prenompat;
	}
	public void setPrenompat(String prenompat) {
		this.prenompat = prenompat;
	}
	public String getNompat() {
		return nompat;
	}
	public void setNompat(String nompat) {
		this.nompat = nompat;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
	
	
	

}
