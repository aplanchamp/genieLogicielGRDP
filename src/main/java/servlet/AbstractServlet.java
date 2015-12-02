package servlet;

import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.TemplateViewRoute;

import java.util.HashMap;
import java.util.Map;

import spark.*;


public abstract class AbstractServlet implements TemplateViewRoute{

	public ModelAndView handle(Request request, Response res) throws Exception {
		if(request.requestMethod() == "POST"){
			if(request.session().isNew())
			{
				request.session(true);                            // create and return session
				request.session().attribute("mail",request.queryParams("userConnect"));   // Get session attribute 'user'
				request.session().attribute("password",request.queryParams("passwordConnect"));
			}
		}

		return null;
	}


}