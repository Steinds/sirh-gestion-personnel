package dev.sgp.entite;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Departement {
@Id
int id;
String nom;



public Departement() {
}

public Departement(int id, String nom) {
	super();
	this.id = id;
	this.nom = nom;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getNom() {
	return nom;
}
public void setNom(String nom) {
	this.nom = nom;
}


}
