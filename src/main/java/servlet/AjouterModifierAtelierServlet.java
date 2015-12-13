package servlet;

import java.util.HashMap;
import java.util.Map;

import database.MainDatabase;
import metier.Atelier;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

public class AjouterModifierAtelierServlet extends AbstractServlet {

	@Override
	public ModelAndView handle(Request req, Response res) throws Exception {

		if (req.requestMethod() == "GET" && req.uri().toString().equals("/modifier")  && req.queryParams("name") != null) {
				// Récupération de l'atelier correspondant au paramètre
						String nameAtelier = req.queryParams("name");
						// Récupération de l'objet Atelier
						Atelier mAtelier = MainDatabase.getAtelierByName(nameAtelier);
						System.out.println("---------------");
						System.out.println("GET /modifier");

						// Ajout de l'objet atelier dans les attributs
						Map<String, Object> attributes = new HashMap<>();
						attributes.put("header", "Modification de l'atelier");
						attributes.put("atelier", mAtelier );
						
						// Renvoi de la page modifier.ftl avec les attributs
						return new ModelAndView(attributes, "modifier.ftl");

		} 
		
		else if (req.requestMethod() == "POST" && req.uri().toString().equals("/modifier")  && req.queryParams("name") != null){

			Map<String, Object> attributes = new HashMap<>();

			try {
				System.out.println("########");
				// Modification d'un atelier par le laboratoire (variable de session)
				MainDatabase.updateAtelier(req.queryParams("name"), req.queryParams("name_atelier"), 
						req.queryParams("desc_atelier"), req.queryParams("lieu_atelier"), req.queryParams("resp_atelier"), 
						req.queryParams("date_atelier"), req.queryParams("hour1_atelier"),req.queryParams("hour2_atelier"), Integer.parseInt(req.queryParams("avail_atelier")));
				System.out.println("%%%%%%");
				// Affiche dans la console les atelier présents (pour le test)
				MainDatabase.printAllAtelier();

				res.redirect("/laboratoire");
				return new ModelAndView(attributes, "errorRedirect.ftl");
			} catch (Exception e) {
				System.out.println("Exception handled - POST TO /listAtelier");
				return new ModelAndView(attributes, "errorRedirect.ftl");

			}

		}
		
		else if (req.requestMethod() == "GET" && req.uri().toString().equals("/ajouter") ) {
			
			//Renvoi de la page ajouter, champs vides
			Map<String, Object> attributes = new HashMap<>();
			attributes.put("header", "Ajouter un l'atelier");
			return new ModelAndView(attributes, "ajoutermodifier.ftl");

		}
		return null;
	}
}