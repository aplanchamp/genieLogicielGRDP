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
				boolean tmp = MainDatabase.addLaboratoire(request.queryParams("name"), request.queryParams("email"),
						request.queryParams("phone"), request.queryParams("password"));

				request.session(true);
				request.session().attribute(request.queryParams("email"), request.queryParams("email"));
				if (tmp == true)
				response.redirect("/laboratoire");

			}

			if (request.queryParams("userConnect") != null) {
				// connexion
				if (MainDatabase.connexionLabo(request.queryParams("userConnect"),
						request.queryParams("passwordConnect"))) {
					request.session(true);
					request.session().attribute(request.queryParams("userConnect"), request.queryParams("userConnect"));
					// connexion ok
					response.redirect("/laboratoire");
				}

			}

			return new ModelAndView(attributes, "errorRedirect.ftl");

		} else if(request.requestMethod() == "GET" && request.queryParams("disconnect") != null) {
			if(!request.session().attributes().isEmpty()){
				request.session().removeAttribute(request.session().attributes().iterator().next());
				response.redirect("/accueil");
			}
			return new ModelAndView(null, "accueil.ftl");
		}
		else{
			Map<String, Object> attributes = new HashMap<>();
			attributes.put("header", "titi");
			attributes.put("user", "coucou");
			return new ModelAndView(attributes, "accueil.ftl");

		}
	}

}
