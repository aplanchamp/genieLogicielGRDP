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
			
				
				// on créé une nouvelle session si besoin
				if(req.session().isNew())
				{
					System.out.println("toto");
					req.session(true);  
					req.session().attribute("mail",req.queryParams("userConnect"));   
					req.session().attribute("password",req.queryParams("passwordConnect"));
					System.out.println("tatta");
				}
				// sinon on vérifie s'il l'user est authentifié


				if (req.session().attribute("mail").equals(req.queryParams("userConnect")) && req.session().attribute("password").equals(req.queryParams("passwordConnect")) )
				{
					System.out.println("tatta");
					return new ModelAndView(attributes, "laboratoire.ftl");
				}
				else {
					res.redirect("/accueil"); 
					System.out.println("coucou je redirige ");
					return new ModelAndView(attributes, "accueil.ftl");
				}
			}
		
		else 
		{
			System.out.println("tata");
			return null;
		}
	
	}

}
