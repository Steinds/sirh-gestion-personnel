package dev.sgp.web;

import java.io.IOException;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.sgp.entite.Stat;

import dev.sgp.service.VisiteWebService;
import dev.sgp.util.Constantes;

@WebServlet("/stat")
public class StatController extends HttpServlet{
	
	@Inject private VisiteWebService visiteService;// = Constantes.VISITE_SERVICE;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws
	ServletException, IOException {
		List<Stat> visites = visiteService.construireStatistiques();
		
		 
		req.setAttribute("visite", visites);
		req.getRequestDispatcher("/WEB-INF/views/visiteWeb/stat.jsp").forward(req, resp);

	}

}
