package servlet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import database.MainDatabase;
import metier.Atelier;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

public class LaboratoireServlet extends AbstractServlet{


	@Override
	public ModelAndView handle(Request req, Response res) throws Exception {

		if(req.requestMethod() == "GET")
		{

			Map<String, Object> attributes = new HashMap<>();
			List<Atelier> listAtelier = new ArrayList<Atelier>();
			attributes.put("header", "Laboratoire");
			attributes.put("laboName", "MonLaboratoireGenial");

			
			try{

			listAtelier = MainDatabase.getAtelierByResponsable("max");
			System.out.println("GET ATELIER PAR RESPONSABLE");

			Iterator i = listAtelier.iterator();
			// Un visiteur veut lister les ateliers disponibles à la date du jour
			
			// attributes contient une liste d'objets Ateliers
			// le template va ensuite "looper" dans cette liste pour les afficher grâce à <#list ateliers as atelier> ... </#list>
			attributes.put("ateliers", listAtelier);
	        return new ModelAndView(attributes, "laboratoire.ftl");
			}
			catch(Exception e){
				//System.out.println("Exception handled - no table Ateliers created yet");
				listAtelier = new ArrayList<Atelier>();
				listAtelier.add(new Atelier("Aucun", "Vous n'avez pas encore enregistré d'atelier", "", "", "", "", "", 0));
				attributes.put("ateliers",listAtelier);
		        return new ModelAndView(attributes, "laboratoire.ftl");
			}

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
//			attributes.put("laboName", "INRIA");
//			attributes.put("atelierTitle", "Un de mes ateliers");
//			attributes.put("atelierDescription", "Voici une description de l'atelier.");    
//			attributes.put("atelierHour1", "9h30");
//			attributes.put("atelierHour2", "coucou");
//			attributes.put("atelierDate", "18/11/2015");    
//			attributes.put("atelierPlace", "ENSEIRB-MATMECA: I111");
//			attributes.put("atelierSupervisor", "MR. Falleri");    
//			attributes.put("atelierAvailable", "10");


		}
		return null;

	}

}
