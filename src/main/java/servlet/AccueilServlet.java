package servlet;

import java.util.HashMap;
import java.util.Map;

import database.MainDatabase;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

public class AccueilServlet extends AbstractServlet {

	@Override
	public ModelAndView handle(Request request, Response response) throws Exception {
		if (request.requestMethod() == "POST") {
			Map<String, Object> attributes = new HashMap<>();
			MainDatabase.createTableLaboratoire();
			if (request.queryParams("name") != null) {
				// inscription
				MainDatabase.addLaboratoire(request.queryParams("name"), request.queryParams("email"),
						request.queryParams("phone"), request.queryParams("password"));
				response.redirect("/laboratoire");

			}

			if (request.queryParams("userConnect") != null) {
				// connexion
				if (MainDatabase.connexionLabo(request.queryParams("userConnect"),
						request.queryParams("passwordConnect"))) {

					// connexion ok
					response.redirect("/laboratoire");
				}

			}

			return new ModelAndView(attributes, "errorRedirect.ftl");

		} else {
			Map<String, Object> attributes = new HashMap<>();
			attributes.put("header", "titi");
			attributes.put("user", "coucou");
			return new ModelAndView(attributes, "accueil.ftl");

		}
	}

}
