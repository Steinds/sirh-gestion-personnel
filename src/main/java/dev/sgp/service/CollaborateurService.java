package dev.sgp.service;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import dev.sgp.entite.CollabEvt;
import dev.sgp.entite.Collaborateur;
import dev.sgp.entite.TypeCollabEvt;

@Stateless
public class CollaborateurService {
	@PersistenceContext(unitName="sgp-pu") private EntityManager em;
	@Inject Event<CollabEvt> collabEvt;
	
	List<Collaborateur> listeCollaborateurs = new ArrayList<>();
	@SuppressWarnings("unchecked")
	public List<Collaborateur> listerCollaborateurs() {		
		Query query = em.createQuery("select collab from Collaborateur collab");		
		return (List<Collaborateur>) query.getResultList();
	}

	public void sauvegarderCollaborateur(Collaborateur collab) {
		CollabEvt nouveauCollabEvent = new CollabEvt(ZonedDateTime.now(ZoneId.systemDefault()),TypeCollabEvt.CREATION_COLLAB, collab.getMatricule());
		listeCollaborateurs.add(collab);
		collabEvt.fire(nouveauCollabEvent);
		em.persist(collab);
		
		
	}
	

	public void modifierCollaborateur(Collaborateur collab) {		
		Collaborateur collaborateur = em.find(Collaborateur.class, collab.getMatricule());
			collaborateur.setEmailPro(collab.getEmailPro());
			collaborateur.setActif(collab.isActif());
			collaborateur.setAdresse(collab.getAdresse());
			collaborateur.setDateHeureCreation(collab.getDateHeureCreation());
			collaborateur.setDateNaissance(collab.getDateNaissance());
			collaborateur.setDep(collab.getDep());
			collaborateur.setPhoto(collab.getPhoto());
			em.merge(collaborateur);
	}
	

		
		
		
	
	
}