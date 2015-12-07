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
		if(request.requestMethod() == "POST"){
			Map<String, Object> attributes = new HashMap<>();
	        attributes.put("header", "tata");
	        attributes.put("user", "coucou");
	        attributes.put("laboName","titi");
	        System.out.println(request.queryParams("userConnect"));
	        System.out.println(request.queryParams("passwordConnect"));
	       
	        MainDatabase.createTableLaboratoire();
	        MainDatabase.addLaboratoire(request.queryParams("name"),request.queryParams("email"),request.queryParams("phone"),request.queryParams("password"));
	        MainDatabase.printAllLaboratoire();
	        //return new ModelAndView(attributes, "accueil.ftl");
	        
	         if(request.session().isNew() ){
	        	
	        	request.session().attribute("userSession", request.queryParams("userConnect"));
	        	request.session().attribute("passwordSession", request.queryParams("passwordConnect"));
		        return new ModelAndView(attributes, "accueil.ftl");

	        	
	        }
	        
	       else {
	        	if(request.session().attribute("userSession").equals(request.queryParams("userConnect")) && request.session().attribute("passwordSession").equals(request.queryParams("passwordConnect"))){
	        	    return new ModelAndView(attributes, "accueil.ftl");	
	        	}
	        	else {
	        		return new ModelAndView(attributes, "accueil.ftl");
	        	}
	        	
	        }
	        
	       
		}
		else{
			Map<String, Object> attributes = new HashMap<>();
	        attributes.put("header", "titi");
	        attributes.put("user", "coucou");        
	        return new ModelAndView(attributes, "accueil.ftl");

		}
		
		
	}

}
