package dev.sgp.filtre;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import dev.sgp.entite.VisiteWeb;
import dev.sgp.service.VisiteWebService;


@WebFilter(urlPatterns = {"/*"})
public class FrequentationFilter implements Filter{
private FilterConfig config = null;
	//récupération du service
	@Inject	private VisiteWebService visiteService;// = Constantes.VISITE_SERVICE;
	
	@Override
	public void init(FilterConfig config) throws ServletException {
		this.config = config;
		config.getServletContext().log("FrequentationFilter initialized");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		long before = System.currentTimeMillis();
		String path = ((HttpServletRequest) request).getRequestURI();
		
		chain.doFilter(request, response);
		
		long after = System.currentTimeMillis();
		config.getServletContext().log(path + " : " + (after - before));
		VisiteWeb visite = new VisiteWeb(1,path,(int)(after - before));
		visiteService.sauvegarderVisite(visite);
		}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}

