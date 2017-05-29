package dev.sgp.entite;

import java.time.LocalDate;
import java.time.ZonedDateTime;


import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Collaborateur {
	@Id
	String matricule;
	String nom;
	String prenom;
	LocalDate dateNaissance;
	String adresse;
	String secu;
	String emailPro;
	String photo;
	ZonedDateTime dateHeureCreation;
	@ManyToOne
	Departement dep;
	@OneToOne
	Banque banque;

	



	public Collaborateur() {
		super();
		
	}

	@Override
	public String toString() {
		return "Collaborateur [matricule=" + matricule + ", nom=" + nom + ", prenom=" + prenom + ", dateNaissance="
				+ dateNaissance + ", adresse=" + adresse + ", secu=" + secu + ", emailPro=" + emailPro + ", photo="
				+ photo + ", dateHeureCreation=" + dateHeureCreation + ", dep=" + dep + ", actif=" + actif + "]";
	}
	
	public Collaborateur(String matricule, String nom, String prenom, LocalDate dateNaissance, String adresse,
			String secu, String emailPro, String photo, ZonedDateTime dateHeureCreation, Departement dep, Banque banque,
			boolean actif) {
		super();
		this.matricule = matricule;
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.adresse = adresse;
		this.secu = secu;
		this.emailPro = emailPro;
		this.photo = photo;
		this.dateHeureCreation = dateHeureCreation;
		this.dep = dep;
		this.banque = banque;
		this.actif = actif;
	}

	@Deprecated
	public Collaborateur(String matricule, String nom, String prenom, LocalDate dateNaissance, String adresse,
			String secu, String emailPro, String photo, ZonedDateTime dateHeureCreation, Departement dep,
			boolean actif) {
		super();
		this.matricule = matricule;
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.adresse = adresse;
		this.secu = secu;
		this.emailPro = emailPro;
		this.photo = photo;
		this.dateHeureCreation = dateHeureCreation;
		this.dep = dep;
		this.actif = actif;
	}
	public Banque getBanque() {
		return banque;
	}
	
	public void setBanque(Banque banque) {
		this.banque = banque;
	}
	public Departement getDep() {
		return dep;
	}


	public void setDep(Departement dep) {
		this.dep = dep;
	}
	boolean actif;
	public String getMatricule() {
		return matricule;
	}
	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public LocalDate getDateNaissance() {
		return dateNaissance;
	}
	public void setDateNaissance(LocalDate dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getSecu() {
		return secu;
	}
	public void setSecu(String secu) {
		this.secu = secu;
	}
	public String getEmailPro() {
		return emailPro;
	}
	public void setEmailPro(String emailPro) {
		this.emailPro = emailPro;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public ZonedDateTime getDateHeureCreation() {
		return dateHeureCreation;
	}
	public void setDateHeureCreation(ZonedDateTime dateHeureCreation) {
		this.dateHeureCreation = dateHeureCreation;
	}
	public boolean isActif() {
		return actif;
	}
	public void setActif(boolean actif) {
		this.actif = actif;
	}
	@Deprecated
	public Collaborateur(String matricule, String nom, String prenom, LocalDate dateNaissance, String adresse,
			String secu, String emailPro, String photo, ZonedDateTime dateHeureCreation, boolean actif) {
		super();
		this.matricule = matricule;
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.adresse = adresse;
		this.secu = secu;
		this.emailPro = emailPro;
		this.photo = photo;
		this.dateHeureCreation = dateHeureCreation;
		this.actif = actif;
	}


}
