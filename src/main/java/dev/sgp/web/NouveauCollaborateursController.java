package dev.sgp.web;

import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.ResourceBundle;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.sgp.entite.Collaborateur;
import dev.sgp.entite.VisiteWeb;
import dev.sgp.service.CollaborateurService;
import dev.sgp.service.VisiteWebService;
import dev.sgp.util.Constantes;

public class NouveauCollaborateursController extends HttpServlet {
	private CollaborateurService collabService = Constantes.COLLAB_SERVICE;
	private VisiteWebService visiteService = Constantes.VISITE_SERVICE;
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws
	ServletException, IOException {
		// utilisation du service
		List<Collaborateur> collaborateurs = collabService.listerCollaborateurs();
	
		req.getRequestDispatcher("/WEB-INF/views/collab/newCollaborateur.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		
		int leftLimit = 97; // letter 'a'
	    int rightLimit = 122; // letter 'z'
	    int targetStringLength = 3;
	    StringBuilder buffer = new StringBuilder(targetStringLength);
	    for (int i = 0; i < targetStringLength; i++) {
	        int randomLimitedInt = leftLimit + (int) 
	          (new Random().nextFloat() * (rightLimit - leftLimit + 1));
	        buffer.append((char) randomLimitedInt);
	    }
	    String matricule = buffer.toString();
		
	    ResourceBundle bundle = ResourceBundle.getBundle("application");
	    String emailEnd = bundle.getString("email");
	    
		String nom =req.getParameter("nom");
		String prenom=req.getParameter("prenom");
		String dateNaissance=req.getParameter("dateNaissance");
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		formatter = formatter.withLocale( Locale.US );  // Locale specifies human language for translating, and cultural norms for lowercase/uppercase and abbreviations and such. Example: Locale.US or Locale.CANADA_FRENCH
		LocalDate date = LocalDate.parse(dateNaissance, formatter);
		String adresse=req.getParameter("adresse");
		String secuNum=req.getParameter("secuNum");
		String emailPro=nom+"."+prenom+"@"+emailEnd;
		String Photo="http://linguaviva.com/wp-content/uploads/2017/03/facebook-avatar.jpg";
		ZonedDateTime dateHeureCreation=ZonedDateTime.now(ZoneId.systemDefault());
		boolean actif=true;
		
		collabService.sauvegarderCollaborateur(new Collaborateur(matricule, nom, prenom, date, adresse, secuNum, emailPro, Photo, dateHeureCreation, actif));
		
		resp.sendRedirect(req.getContextPath()+ "/collaborateurs/lister");
		
	}

}
