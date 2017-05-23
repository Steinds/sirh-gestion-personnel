package dev.sgp.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import dev.sgp.entite.VisiteWeb;
import dev.sgp.service.VisiteWebService;
import dev.sgp.util.Constantes;

public class StatController extends HttpServlet{
	private VisiteWebService visiteService = Constantes.VISITE_SERVICE;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws
	ServletException, IOException {
		List<VisiteWeb> visites = visiteService.listerVisiteWeb();
		List<String> paths= visiteService.listerPath();
		
		req.setAttribute("visites", visites);
		req.getRequestDispatcher("/WEB-INF/views/visiteWeb/stat.jsp").forward(req, resp);

	}

}
