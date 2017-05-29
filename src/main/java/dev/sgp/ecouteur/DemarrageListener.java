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

import dev.sgp.entite.Banque;
import dev.sgp.entite.Collaborateur;
import dev.sgp.entite.Departement;
import dev.sgp.service.BanqueService;
import dev.sgp.service.CollaborateurService;
import dev.sgp.service.DepartementService;

@WebListener
public class DemarrageListener implements ServletContextListener {

	@Inject private CollaborateurService collabService;
	@Inject private DepartementService depService;	
	@Inject private BanqueService banqueService;
	
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
		Departement dep1 = new Departement(1, "Administration");
		Departement dep2 =new Departement(2, "Developpement");
		Departement dep3=new Departement(3, "RH");
		depService.sauvegarderDepartement(dep1);
    	depService.sauvegarderDepartement(dep2);
		depService.sauvegarderDepartement(dep3);
		Banque banque1= new Banque("Credit Agricole", "152245566232", "562652");
		Banque banque2=new Banque("Credit Lyonnais", "752565566232", "356215");
		banqueService.sauvegarderBanque(banque1);
		banqueService.sauvegarderBanque(banque2);
		collabService.sauvegarderCollaborateur(new Collaborateur(matricule, nom, prenom, date, "20 rue du canard laqué", "111111111111111", nom+"."+prenom+"@"+emailEnd, "http://d3ba5c9iisu9nv.cloudfront.net/wp-content/uploads/2016/01/david-bowie-06.jpg", ZonedDateTime.now(ZoneId.systemDefault()),dep1,banque1, true));
		collabService.sauvegarderCollaborateur(new Collaborateur("m01", nom, prenom, date, "21 rue du canard laqué", "111121111111111", nom+"."+prenom+"@"+emailEnd, "http://www.le-serpent-retrogamer.org/wp-content/uploads/2015/11/DB0.jpg", ZonedDateTime.now(ZoneId.systemDefault()),dep2,banque2, true));
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub

	}

}
