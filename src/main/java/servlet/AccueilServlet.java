package servlet;

import java.util.HashMap;
import java.util.Map;

import spark.ModelAndView;
import spark.Request;
import spark.Response;

public class AccueilServlet extends AbstractServlet {

	@Override
	public ModelAndView handle(Request request, Response response) throws Exception {  	
		if(request.requestMethod() == "GET"){
			Map<String, Object> attributes = new HashMap<>();
	        attributes.put("header", "toto");
	        attributes.put("user", "coucou");        
	        return new ModelAndView(attributes, "hello.ftl");
		}
		else if(request.requestMethod() == "POST"){
			Map<String, Object> attributes = new HashMap<>();
	        attributes.put("header", "tata");
	        attributes.put("user", "coucou");        
	        return new ModelAndView(attributes, "theme.ftl");
		}
		else{
			Map<String, Object> attributes = new HashMap<>();
	        attributes.put("header", "titi");
	        attributes.put("user", "coucou");        
	        return new ModelAndView(attributes, "hello.ftl");
		}
		


	}

}
