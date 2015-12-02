package servlet;

import java.util.HashMap;
import java.util.Map;

import spark.ModelAndView;
import spark.Request;
import spark.Response;

public class LaboratoireServlet extends AbstractServlet{

	@Override
	public ModelAndView handle(Request req, Response res) throws Exception {
		if(req.requestMethod() == "GET"){
			System.out.println("toto");
			Map<String, Object> attributes = new HashMap<>();
			attributes.put("header", "Laboratoire");
			return new ModelAndView(attributes, "laboratoire.ftl");
		}
		else {
			System.out.println("tata");
			return null;
		}
	}
	
}
