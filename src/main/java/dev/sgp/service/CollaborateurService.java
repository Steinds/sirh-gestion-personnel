package dev.sgp.service;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Event;
import javax.inject.Inject;

import dev.sgp.entite.CollabEvt;
import dev.sgp.entite.Collaborateur;
import dev.sgp.entite.TypeCollabEvt;

@ApplicationScoped
public class CollaborateurService {
	
	@Inject Event<CollabEvt> collabEvt;
	
	List<Collaborateur> listeCollaborateurs = new ArrayList<>();
	public List<Collaborateur> listerCollaborateurs() {
		return listeCollaborateurs;
	}

	public void sauvegarderCollaborateur(Collaborateur collab) {
		CollabEvt nouveauCollabEvent = new CollabEvt(ZonedDateTime.now(ZoneId.systemDefault()),TypeCollabEvt.CREATION_COLLAB, collab.getMatricule());
		listeCollaborateurs.add(collab);
		collabEvt.fire(nouveauCollabEvent);
		

	}

}