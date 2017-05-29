package dev.sgp.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import dev.sgp.entite.Banque;
import dev.sgp.entite.Collaborateur;

@Stateless
public class BanqueService {
	@PersistenceContext(unitName="sgp-pu") private EntityManager em;
	
	
	List<Banque> listeBanques = new ArrayList<>();
	@SuppressWarnings("unchecked")
	public List<Banque> listerBanques() {		
		Query query = em.createQuery("select Banque from Banque Banque");		
		return (List<Banque>) query.getResultList();
	}

	public void sauvegarderBanque(Banque Banque) {	
		listeBanques.add(Banque);		
		em.persist(Banque);
		
		
	}

	public void modifierCollaborateurBank(Collaborateur collab) {		
		Collaborateur collaborateur = em.find(Collaborateur.class, collab.getMatricule());
			collaborateur.setBanque(collab.getBanque());
			em.merge(collaborateur);
	}
}