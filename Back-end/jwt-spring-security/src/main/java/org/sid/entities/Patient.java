package org.sid.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Patient {
	@Id @GeneratedValue
	private  Long id ;
	@Column(unique=true)
	private String username; 
	private String nom; 
	private int num_cin;
	public Patient() {
		super();
	}
	public Patient(String username, String nom, int num_cin, int matricule_sociale, String type_couverture,
			String prenom, String tel, Date date_Naissace) {
		super();
		this.username = username;
		this.nom = nom;
		this.num_cin = num_cin;
		this.matricule_sociale = matricule_sociale;
		this.type_couverture = type_couverture;
		this.prenom = prenom;
		this.tel = tel;
		Date_Naissace = date_Naissace;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public int getNum_cin() {
		return num_cin;
	}
	public void setNum_cin(int num_cin) {
		this.num_cin = num_cin;
	}
	public int getMatricule_sociale() {
		return matricule_sociale;
	}
	public void setMatricule_sociale(int matricule_sociale) {
		this.matricule_sociale = matricule_sociale;
	}
	public String getType_couverture() {
		return type_couverture;
	}
	public void setType_couverture(String type_couverture) {
		this.type_couverture = type_couverture;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public Date getDate_Naissace() {
		return Date_Naissace;
	}
	public void setDate_Naissace(Date date_Naissace) {
		Date_Naissace = date_Naissace;
	}
	private int matricule_sociale;
	private String type_couverture;
	private String prenom ;
	private String tel ;
	@Temporal(TemporalType.DATE)
	private Date Date_Naissace;

}
