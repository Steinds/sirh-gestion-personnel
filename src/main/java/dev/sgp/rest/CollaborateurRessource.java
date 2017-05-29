package dev.sgp.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import dev.sgp.entite.Banque;
import dev.sgp.entite.Collaborateur;
import dev.sgp.service.BanqueService;
import dev.sgp.service.CollaborateurService;

@Path("/collaborateurs")
public class CollaborateurRessource {
	@PersistenceContext(unitName="sgp-pu") private EntityManager em;
	@Inject private CollaborateurService collabService;
	@Inject private BanqueService bankService;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Collaborateur> listAll(@QueryParam("departement") Integer id) {
		List<Collaborateur> collabo =new ArrayList<Collaborateur>();
		if (id!=null)	{
			Query query = em.createQuery("select collab from Collaborateur collab where collab.dep.id =:id ");
			query.setParameter("id", id);
			collabo=(List<Collaborateur>) query.getResultList();
		}else {
			collabo = collabService.listerCollaborateurs();
		}
		return collabo;
	}


	@SuppressWarnings("unchecked")
	@GET
	@Path("/{matricule}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Collaborateur> listDep(@PathParam("matricule") String matricule) {
		Query query = em.createQuery("select collab from Collaborateur collab where collab.matricule =:matricule ");
		query.setParameter("matricule", matricule);
		return  (List<Collaborateur>) query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@GET
	@Path("/{matricule}/banque")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Banque> listBanque(@PathParam("matricule") String matricule) {
		Query query = em.createQuery("select collab.banque from Collaborateur collab where collab.matricule =:matricule ");
		query.setParameter("matricule", matricule);
		return  (List<Banque>) query.getResultList();
	}



	@PUT
	@Path("/{matricule}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Map<String,List<String>>  updateColla(Collaborateur collab,@PathParam("matricule") String matricule) {	  
		Collaborateur old = em.find(Collaborateur.class, matricule);
		collabService.modifierCollaborateur(collab);
		return collabService.checkJson(old, collab);
	}

	@PUT
	@Path("/{matricule}/banque")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Map<String,List<String>>  updateBanque(Collaborateur collab,@PathParam("matricule") String matricule) {	  
		Collaborateur old = em.find(Collaborateur.class, matricule);
		bankService.modifierCollaborateurBank(collab);
		return collabService.checkJson(old, collab);
	}



}
