package servlet;

import java.util.HashMap;
import java.util.Map;

import spark.ModelAndView;
import spark.Request;
import spark.Response;

public class AccueilServlet extends AbstractServlet {

	@Override
	public ModelAndView handle(Request request, Response response) throws Exception {  	
		if(request.requestMethod() == "POST"){
			Map<String, Object> attributes = new HashMap<>();
	        attributes.put("header", "tata");
	        attributes.put("user", "coucou");
	        
	        System.out.println(request.queryParams("name"));
	        System.out.println(request.queryParams("email"));
	        System.out.println(request.queryParams("phone"));
	        System.out.println(request.queryParams("password"));
	        System.out.println(request.queryParams("userConnect"));
	        System.out.println(request.queryParams("passwordConnect"));
	        return new ModelAndView(attributes, "hello.ftl");
		}
		else{
			Map<String, Object> attributes = new HashMap<>();
	        attributes.put("header", "titi");
	        attributes.put("user", "coucou");        
<<<<<<< HEAD
	        return new ModelAndView(attributes, "accueil.ftl");
=======
	        return new ModelAndView(attributes, "hello.ftl");
>>>>>>> c6df16b0e426851d2954fb3eb7c50266fff54736
		}
	}

}
