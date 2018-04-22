package org.sid.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Medecin implements Serializable {
	public Long getId_med() {
		return id_med;
	}

	public void setId_med(Long id_med) {
		this.id_med = id_med;
	}

	public Medecin() {
		super();
	}

	@Override
	public String toString() {
		return "Medecin [id_med=" + id_med + ", Matricule=" + Matricule + ", Nom=" + Nom + ", Prenom=" + Prenom
				+ ", Date_Naissace=" + Date_Naissace + ", Etat=" + Etat + ", Pseudo=" + Pseudo + "]";
	}

	public Medecin(int etat,int matricule, String nom, String prenom, Date date_Naissace, String pseudo) {
		super();
		Etat=etat;
		Matricule = matricule;
		Nom = nom;
		Prenom = prenom;
		Date_Naissace = date_Naissace;
		Pseudo = pseudo;
		
		
	}

	
	public int getMatricule() {
		return Matricule;
	}

	public void setMatricule(int matricule) {
		Matricule = matricule;
	}

	public String getNom() {
		return Nom;
	}

	public void setNom(String nom) {
		Nom = nom;
	}

	public String getPrenom() {
		return Prenom;
	}

	public void setPrenom(String prenom) {
		Prenom = prenom;
	}

	public Date getDate_Naissace() {
		return Date_Naissace;
	}

	public void setDate_Naissace(Date date_Naissace) {
		Date_Naissace = date_Naissace;
	}

	public String getPseudo() {
		return Pseudo;
	}

	public void setPseudo(String pseudo) {
		Pseudo = pseudo;
	}

	@Id @GeneratedValue
	private Long id_med;
	
	private int Matricule ;
	
	private String Nom;
	private String Prenom;
	@Temporal(TemporalType.DATE)
	private Date Date_Naissace;
	private int Etat;
	
	public int getEtat() {
		return Etat;
	}

	public void setEtat(int etat) {
		Etat = etat;
	}

	private String  Pseudo;
	@Column(unique=true)
	private String username ;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	
	
	

}

