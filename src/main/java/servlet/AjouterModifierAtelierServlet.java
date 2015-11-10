package servlet;

import spark.Request;
import spark.Response;

public class AjouterModifierAtelierServlet extends AbstractServlet{

	@Override
	public Object handle(Request req, Response res) throws Exception {
		return "ajouter/mod/atelier";
	}
}