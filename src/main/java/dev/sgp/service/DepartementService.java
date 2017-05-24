package dev.sgp.service;


import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


import dev.sgp.entite.Departement;


@Stateless
public class DepartementService {
	@PersistenceContext(unitName="sgp-pu") private EntityManager em;
	
	
	List<Departement> listeDepartements = new ArrayList<>();
	public List<Departement> listerDepartements() {		
		Query query = em.createQuery("select departement from Departement departement");		
		return (List<Departement>) query.getResultList();
	}

	public void sauvegarderDepartement(Departement departement) {	
		listeDepartements.add(departement);		
		em.persist(departement);
		
		
	}

}
