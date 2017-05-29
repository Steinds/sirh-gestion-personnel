package dev.sgp.entite;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Banque {
@Id
String Name;
String IBAN;
String BIC;
public Banque(String name, String iBAN, String bIC) {
	super();
	Name = name;
	IBAN = iBAN;
	BIC = bIC;
}

public Banque() {

}

@Override
public String toString() {
	return "Banque [Name=" + Name + ", IBAN=" + IBAN + ", BIC=" + BIC + "]";
}
public String getName() {
	return Name;
}
public void setName(String name) {
	Name = name;
}
public String getIBAN() {
	return IBAN;
}
public void setIBAN(String iBAN) {
	IBAN = iBAN;
}
public String getBIC() {
	return BIC;
}
public void setBIC(String bIC) {
	BIC = bIC;
}

}
