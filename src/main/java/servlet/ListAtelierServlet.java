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
				return new ModelAndView(attributes, "errorNoListAtelier.ftl");
			}
		} 

		Map<String, Object> attributes = new HashMap<>(); // vide
		return new ModelAndView(attributes, "errorRedirect.ftl");

	}

}
