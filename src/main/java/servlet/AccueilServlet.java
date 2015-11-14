package servlet;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import freemarker.template.Configuration;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.TemplateViewRoute;
import spark.template.freemarker.FreeMarkerEngine;

public class AccueilServlet extends AbstractServlet {

	@Override
	public ModelAndView handle(Request request, Response response) throws Exception {
		Configuration config = new Configuration();
    	config.setDirectoryForTemplateLoading(new File("src/main/resources"));
    	config.setDefaultEncoding("UTF-8");

       	FreeMarkerEngine freeEngine = new FreeMarkerEngine();
    	freeEngine.setConfiguration(config);
    	
    	Map<String, Object> attributes = new HashMap<>();
        attributes.put("header", "CNRS BORDEAUX");
        attributes.put("user", "coucou");
        
        return new ModelAndView(attributes, "hello.ftl");
        
        //return "foo";
	}

}
