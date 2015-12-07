package servlet;

import java.util.HashMap;
import java.util.Map;

import spark.ModelAndView;
import spark.Request;
import spark.Response;

public class LaboratoireServlet extends AbstractServlet{


	@Override
	public ModelAndView handle(Request req, Response res) throws Exception {

		if(req.requestMethod() == "GET")
		{

			Map<String, Object> attributes = new HashMap<>();
			attributes.put("header", "Laboratoire");

			// on cr�� une nouvelle session si besoin
		/*	if(req.session().isNew())
			{
				System.out.println("toto");
				req.session(true);  
				req.session().attribute("mail",req.queryParams("userConnect"));   
				req.session().attribute("password",req.queryParams("passwordConnect"));
				System.out.println("tatta");
				return new ModelAndView(attributes, "laboratoire.ftl");
			}
			// sinon on v�rifie s'il l'user est authentifi�


			else if (req.session().attribute("mail").equals(req.queryParams("userConnect")) && req.session().attribute("password").equals(req.queryParams("passwordConnect")) )
			{
				System.out.println("tatta");
				return new ModelAndView(attributes, "laboratoire.ftl");
			}
			else {
				res.redirect("/accueil"); 
				System.out.println("coucou je redirige ");
				return new ModelAndView(attributes, "accueil.ftl");
			}*/
		

		
			// Exemple d'infos pour un atelier listé
			attributes.put("laboName", "INRIA");
			attributes.put("atelierTitle", "Un de mes ateliers");
			attributes.put("atelierDescription", "Voici une description de l'atelier.");    
			attributes.put("atelierHour1", "9h30");
			attributes.put("atelierHour2", "coucou");
			attributes.put("atelierDate", "18/11/2015");    
			attributes.put("atelierPlace", "ENSEIRB-MATMECA: I111");
			attributes.put("atelierSupervisor", "MR. Falleri");    
			attributes.put("atelierAvailable", "10");


			return new ModelAndView(attributes, "laboratoire.ftl");
		}
		return null;

	}

}
