package dev.sgp.service;

import java.util.ArrayList;
import java.util.List;


import dev.sgp.entite.VisiteWeb;

public class VisiteWebService {
	List<VisiteWeb> listeVisiteWeb = new ArrayList<>();
	List<String> Paths = new ArrayList<>();
	
	public List<VisiteWeb> listerVisiteWeb() {
		return listeVisiteWeb;
	}
	public List<String> listerPath() {
		return Paths;
	}

	public void sauvegarderVisiteWeb(VisiteWeb visite) {
		listeVisiteWeb.add(visite);

	}

}
