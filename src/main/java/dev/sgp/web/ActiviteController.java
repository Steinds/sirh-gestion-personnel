package dev.sgp.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.sgp.entite.CollabEvt;
import dev.sgp.entite.Collaborateur;
import dev.sgp.service.ActiviteService;
import dev.sgp.service.CollaborateurService;

@WebServlet("/activite")
public class ActiviteController extends HttpServlet {
	@Inject private ActiviteService activiteService;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws
	ServletException, IOException {
		// utilisation du service
	
		List<CollabEvt> listeCollabEvt = activiteService.listerActivitesCollab();
		
		req.setAttribute("listeEvt", listeCollabEvt);
		req.getRequestDispatcher("/WEB-INF/views/collab/activite.jsp").forward(req, resp);
	}

}
