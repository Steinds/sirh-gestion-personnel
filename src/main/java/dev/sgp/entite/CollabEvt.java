package dev.sgp.entite;

import java.time.ZonedDateTime;

public class CollabEvt {
	ZonedDateTime dateHeure ;
	TypeCollabEvt type ;
	String matricule ;
	
	public CollabEvt(ZonedDateTime dateHeure, TypeCollabEvt type, String matricule) {
		super();
		this.dateHeure = dateHeure;
		this.type = type;
		this.matricule = matricule;
	}

	public ZonedDateTime getDateHeure() {
		return dateHeure;
	}

	public void setDateHeure(ZonedDateTime dateHeure) {
		this.dateHeure = dateHeure;
	}

	public TypeCollabEvt getType() {
		return type;
	}

	public void setType(TypeCollabEvt type) {
		this.type = type;
	}

	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}
	
}
