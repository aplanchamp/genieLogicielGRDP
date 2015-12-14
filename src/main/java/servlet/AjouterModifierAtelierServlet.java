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

						// Ajout de l'objet atelier dans les attributs
						Map<String, Object> attributes = new HashMap<>();
						attributes.put("header", "Modification de l'atelier");
						attributes.put("atelier", mAtelier );
						
						// Renvoi de la page modifier.ftl avec les attributs
						return new ModelAndView(attributes, "modifier.ftl");

		} 
		
		else if (req.requestMethod() == "GET" && req.uri().toString().equals("/delete")  && req.queryParams("name") != null) {
			// Récupération de l'atelier correspondant au paramètre
			String nameAtelier = req.queryParams("name");
			// delete de l'atelier name
			MainDatabase.deleteAtelierByName(nameAtelier);
			res.redirect("/laboratoire");
			return new ModelAndView(null, "errorRedirect.ftl");

} 
		
		else if (req.requestMethod() == "POST" && req.uri().toString().equals("/modifier")  && req.queryParams("name") != null){


			try {
				// Modification d'un atelier par le laboratoire (variable de session)
				MainDatabase.updateAtelier(req.queryParams("name"), req.queryParams("name_atelier"), 
						req.queryParams("desc_atelier"), req.queryParams("lieu_atelier"), req.session().attributes().iterator().next(), 
						req.queryParams("date_atelier"), req.queryParams("hour1_atelier"),req.queryParams("hour2_atelier"), 
						Integer.parseInt(req.queryParams("avail_atelier")));

				res.redirect("/laboratoire");
				return new ModelAndView(null, "errorRedirect.ftl");
			} catch (Exception e) {
				System.out.println("Exception handled - POST TO /listAtelier");
				return new ModelAndView(null, "errorRedirect.ftl");

			}

		}
		
		else if (req.requestMethod() == "GET" && req.uri().toString().equals("/ajouter") ) {
			
			//Renvoi de la page ajouter, champs vides
			Map<String, Object> attributes = new HashMap<>();
			attributes.put("header", "Ajouter un l'atelier");
			return new ModelAndView(attributes, "ajoutermodifier.ftl");

		}
		
		else if (req.requestMethod() == "POST" && req.uri().toString().equals("/ajouter")) {

			// Un visiteur veut ajouter un atelier depuis l'uri /ajouter
			// Ici, les paramètres doivent être rentrés dans la base de données,
			// puis une redirection est faite vers la page laboratoire
			// pour visualiser ses ateliers
			try {
				// Création de la table ATELIER
				MainDatabase.createTableAtelier();

				// Ajout d'un atelier par le laboratoire (variable de session)
				boolean mbol = MainDatabase.addAtelier(req.queryParams("name_atelier"), req.queryParams("desc_atelier"),
						req.queryParams("lieu_atelier"),req.session().attributes().iterator().next(),
						req.queryParams("date_atelier"), req.queryParams("hour1_atelier"), req.queryParams("hour2_atelier"), Integer.parseInt(req.queryParams("avail_atelier")));
				
				if (mbol == true)
					res.redirect("/laboratoire");
				return new ModelAndView(null, "errorRedirect.ftl");
			} catch (Exception e) {
				System.out.println("Exception handled - POST TO /listAtelier");
				return new ModelAndView(null, "errorRedirect.ftl");

			}

		}
		return null;
	}
}