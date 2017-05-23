package dev.sgp.web;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/collaborateurs/editer")
public class EditerCollaborateurController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws
	ServletException, IOException {

		// récupère la valeur d'un paramètre dont le nom est matricule
		String matriculeParam = req.getParameter("matricule");
		if (matriculeParam != null || !matriculeParam.equals("")) { 
			resp.setContentType("text/html");
			// code HTML écrit dans le corps de la réponse
			resp.getWriter().write("<h1>Edition de Collaborateur</h1>"
					+ "<p>matricule="+ matriculeParam + "<p>");}
		else {
			resp.sendError(400,"un matricule est attendu");
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// récupère la valeur d'un paramètre dont le nom est matricule
		String matriculeParam = req.getParameter("matricule");
		// récupère la valeur d'un paramètre dont le nom est titre
		String titreParam = req.getParameter("titre");
		// récupère la valeur d'un paramètre dont le nom est nom
		String nomParam = req.getParameter("nom");
		// récupère la valeur d'un paramètre dont le nom est prenom
		String prenomParam = req.getParameter("prenom");
		String errorParam ="";
		if (matriculeParam==null || titreParam==null || nomParam==null || prenomParam==null) {
			if( matriculeParam ==null || matriculeParam.equals("")) errorParam=errorParam+" matricule";
			if( titreParam==null|| titreParam.equals("")) errorParam=errorParam+" titre";
			if( nomParam ==null ||nomParam.equals("")) errorParam=errorParam+" nom";
			if( prenomParam ==null || prenomParam.equals("")) errorParam=errorParam+" prenom";
			resp.sendError(400,"Les Champs suivants sont manquants:" +errorParam);
		}else {
			resp.setContentType("text/html");
			// code HTML écrit dans le corps de la réponse
			resp.getWriter().write("<h1>Edition de Collaborateur</h1>"
					+ "<p>matricule="+ matriculeParam + "<p>"
					+ "<p>titre="+ titreParam + "<p>"
					+ "<p>nom="+ nomParam + "<p>"
					+ "<p>prenom="+ prenomParam + "<p>");}
	}

}