package servlet;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import database.MainDatabase;
import metier.Atelier;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

public class ListAtelierServlet extends AbstractServlet {

	@Override
	public ModelAndView handle(Request req, Response res) throws Exception {

		if (req.requestMethod() == "GET" && req.uri().toString().equals("/listAtelier")) {
			System.out.println("Get de /listAtelier");
			Map<String, Object> attributes = new HashMap<>();

			try {
				List<Atelier> listAtelier = MainDatabase.getAllAtelier();
				Iterator i = listAtelier.iterator();
				// Un visiteur veut lister les ateliers disponibles à la date du
				// jour

				// attributes contient une liste d'objets Ateliers
				// le template va ensuite "looper" dans cette liste pour les
				// afficher grâce à <#list ateliers as atelier> ... </#list>
				attributes.put("header", "Liste des ateliers");
				attributes.put("ateliers", listAtelier);

				return new ModelAndView(attributes, "listAtelier.ftl");
			} catch (Exception e) {
				System.out.println("Exception handled - no table Ateliers created yet");
				return new ModelAndView(attributes, "errorRedirect.ftl");
			}
		} else if (req.requestMethod() == "POST" && req.uri().toString().equals("/listAtelier")) {
			System.out.println("methode post et /listAtelier détecté");
			Map<String, Object> attributes = new HashMap<>();

			// Un visiteur veut ajouter un atelier depuis l'uri /ajouter
			// Ici, les paramètres doivent être rentrés dans la base de données,
			// puis une redirection est faite vers la page laboratoire
			// pour visualiser ses ateliers
			try {
				// Création de la table ATELIER
				MainDatabase.createTableAtelier();

				// Ajout d'un atelier par le laboratoire (variable de session)
				MainDatabase.addAtelier(req.queryParams("name_atelier"), req.queryParams("desc_atelier"),
						req.queryParams("lieu_atelier"), req.queryParams("resp_atelier"),
						req.queryParams("date_atelier"), "10h", Integer.parseInt(req.queryParams("avail_atelier")));
				MainDatabase.printAllAtelier();

				res.redirect("/laboratoire");
				return new ModelAndView(attributes, "errorRedirect.ftl");
			} catch (Exception e) {
				System.out.println("Exception handled - POST TO /listAtelier");
				return new ModelAndView(attributes, "errorRedirect.ftl");

			}

		}
		Map<String, Object> attributes = new HashMap<>(); // vide
		return new ModelAndView(attributes, "errorRedirect.ftl");

	}

}
