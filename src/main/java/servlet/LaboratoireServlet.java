package servlet;

import spark.Request;
import spark.Response;

public class LaboratoireServlet extends AbstractServlet{
	
	@Override
	public Object handle(Request req, Response res) throws Exception {
		return "Laboratoire Servlet";
	}
}
