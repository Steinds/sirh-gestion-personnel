package dev.sgp.ecouteur;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Random;
import java.util.ResourceBundle;

import javax.inject.Inject;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import dev.sgp.entite.Collaborateur;
import dev.sgp.entite.Departement;
import dev.sgp.service.CollaborateurService;
import dev.sgp.service.DepartementService;

@WebListener
public class DemarrageListener implements ServletContextListener {

	@Inject private CollaborateurService collabService;
	@Inject private DepartementService depService;	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
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
	    String nom ="Bowie" ;
	    String prenom= "David";
	    ResourceBundle bundle = ResourceBundle.getBundle("application");
	    String emailEnd = bundle.getString("email");
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		formatter = formatter.withLocale( Locale.US );  // Locale specifies human language for translating, and cultural norms for lowercase/uppercase and abbreviations and such. Example: Locale.US or Locale.CANADA_FRENCH
		LocalDate date = LocalDate.parse("1900-01-01", formatter);
		collabService.sauvegarderCollaborateur(new Collaborateur(matricule, nom, prenom, date, "", "111111111111111", nom+"."+prenom+"@"+emailEnd, "http://linguaviva.com/wp-content/uploads/2017/03/facebook-avatar.jpg", ZonedDateTime.now(ZoneId.systemDefault()), true));
		depService.sauvegarderDepartement(new Departement(1, "Administration"));
		depService.sauvegarderDepartement(new Departement(2, "Developpement"));
		depService.sauvegarderDepartement(new Departement(3, "RH"));
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		
	}

}
