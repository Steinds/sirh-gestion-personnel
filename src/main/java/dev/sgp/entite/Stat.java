package dev.sgp.entite;

public class Stat {

String chemin;
long nbVisites;
long min;
long max;
double moy;



public Stat(String chemin, long l, long m, long n, double d) {
	super();
	this.chemin = chemin;
	this.nbVisites = l;
	this.min = m;
	this.max = n;
	this.moy = d;
}

public long getMin() {
	return min;
}

public void setMin(long min) {
	this.min = min;
}

public long getMax() {
	return max;
}

public void setMax(long max) {
	this.max = max;
}

public double getMoy() {
	return moy;
}

public void setMoy(double moy) {
	this.moy = moy;
}

public void setNbVisites(long nbVisites) {
	this.nbVisites = nbVisites;
}

public void incrementNbVisites() {
	this.nbVisites++;
}

public String getChemin() {
	return chemin;
}
public void setChemin(String chemin) {
	this.chemin = chemin;
}
public long getNbVisites() {
	return nbVisites;
}
public void setNbVisites(int nbVisites) {
	this.nbVisites = nbVisites;
}

}
