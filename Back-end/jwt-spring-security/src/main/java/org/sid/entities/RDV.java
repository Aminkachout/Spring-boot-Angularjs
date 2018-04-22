package org.sid.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
public class RDV {
	@Id @GeneratedValue
	private Long id;
	public String getUsernamemed() {
		return usernamemed;
	}
	public void setUsernamemed(String usernamemed) {
		this.usernamemed = usernamemed;
	}
	public RDV() {
		super();
	}
	
	private String usernamemed;
	private String nom ;
	@Temporal(TemporalType.DATE)

	private Date date ;
	public RDV( String usernamemed, String nom, Date date) {
		super();
		
		this.usernamemed = usernamemed;
		this.nom = nom;
		this.date = date;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	
}
