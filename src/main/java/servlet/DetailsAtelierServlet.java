package servlet;

import java.util.HashMap;
import java.util.Map;

import spark.ModelAndView;
import spark.Request;
import spark.Response;

public class DetailsAtelierServlet extends AbstractServlet{

	@Override
	public ModelAndView handle(Request req, Response res) throws Exception {
		if(req.requestMethod() == "GET"){
			System.out.println("toto");
			Map<String, Object> attributes = new HashMap<>();
			attributes.put("header", "Atelier");
			attributes.put("user", "coucou");        
			attributes.put("atelierTitle", "Programmation web");
			attributes.put("atelierDescription", "Voici une description de l'atelier.");    
			attributes.put("atelierHour1", "9h30");
			attributes.put("atelierHour2", "coucou");
			attributes.put("atelierDate", "18/11/2015");    
			attributes.put("atelierPlace", "ENSEIRB-MATMECA: I111");
			attributes.put("atelierSupervisor", "MR. Falleri");    
			attributes.put("atelierAvailable", "10");
			return new ModelAndView(attributes, "detailsAtelier.ftl");
		}
		else if(req.requestMethod() == "POST"){
			System.out.println("coucou");
			// Un visiteur veut s'inscrire à un atelier, il a appuyé sur le bouton d'inscription
			Map<String, Object> attributes = new HashMap<>();
			attributes.put("header", "Atelier");
			attributes.put("user", "coucou");       
			attributes.put("msg", "T'es bien inscrit à l'atelier");    
	        return new ModelAndView(attributes, "detailsAtelierSubmit.ftl");
		}
		else {
			System.out.println("tata");
			return null;
		}
	}
}