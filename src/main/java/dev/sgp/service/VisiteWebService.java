package dev.sgp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.LongSummaryStatistics;
import java.util.Map;

import static java.util.stream.Collectors.*;

import dev.sgp.entite.Stat;
import dev.sgp.entite.VisiteWeb;

public class VisiteWebService {

	List<VisiteWeb> listeVisites = new ArrayList<>();

	public List<VisiteWeb> listerVisites() {
		return listeVisites;
	}

	public void sauvegarderVisite(VisiteWeb visite) {
		listeVisites.add(visite);
	}

	public List<Stat> construireStatistiques() {
		List<Stat> statistiques = new ArrayList<>();
		
		Map<String, List<VisiteWeb>> cheminListeVisites = listeVisites.stream().collect(groupingBy(VisiteWeb::getChemin));
		
		cheminListeVisites.forEach((chemin, listeVisites) -> {
			statistiques.add(construireVisiteLog(chemin, listeVisites));
		});
		
		return statistiques;
	}
	
	
	public Stat construireVisiteLog(String chemin, List<VisiteWeb> listeVisites) {
		LongSummaryStatistics stats = listeVisites.stream().collect(
				summarizingLong(VisiteWeb::getTempsExecution));
		return new Stat(chemin, stats.getCount(), stats.getMin(), stats.getMax(), stats.getAverage());
	}


}