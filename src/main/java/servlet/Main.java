package servlet;

import static spark.Spark.*;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import freemarker.template.Configuration;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.Spark;
import spark.TemplateViewRoute;
import spark.template.freemarker.FreeMarkerEngine;

public class Main {
	
    public static void main(String[] args) throws IOException {
    	
    	Configuration config = new Configuration();
    	config.setDirectoryForTemplateLoading(new File("src/main/resources"));
    	config.setDefaultEncoding("UTF-8");
    	FreeMarkerEngine freeEngine = new FreeMarkerEngine();
    	freeEngine.setConfiguration(config);
    	
    	// Redirection vers la servlet accueil
    	get("/",(Request req,Response resp)->{
    		resp.redirect("/accueil");
    		return null;
    	});  
    	
        get("/accueil", new AccueilServlet(),freeEngine);
        get("/laboratoire", new LaboratoireServlet(),freeEngine);
        get("/detailsAtelier", new DetailsAtelierServlet(),freeEngine);
        get("/ajouter", new AjouterModifierAtelierServlet(),freeEngine);
        
    }
}