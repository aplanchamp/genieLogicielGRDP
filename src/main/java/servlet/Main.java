package servlet;

import static spark.Spark.*;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import database.MainDatabase;
import freemarker.template.Configuration;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.template.freemarker.FreeMarkerEngine;

public class Main {
	
    public static void main(String[] args) throws IOException, SQLException {
    	
    	Configuration config = new Configuration();
    	config.setDirectoryForTemplateLoading(new File("src/main/resources"));
    	config.setDefaultEncoding("UTF-8");
    	FreeMarkerEngine freeEngine = new FreeMarkerEngine();
    	freeEngine.setConfiguration(config);
    	
        staticFileLocation("/css");
        
        // Pour les tests, à chaque redémarrage, les tables sont supprimées
        MainDatabase.dropTableAteliers();
        MainDatabase.dropTableLaboratoire();
        
    	
    	// Redirection vers la servlet accueil
    	get("/",(Request req,Response resp)->{
    		resp.redirect("/accueil");
    		return null;
    	});  
    	
        get("/accueil", new AccueilServlet(),freeEngine);
        post("/accueil", new AccueilServlet(),freeEngine);
        get("/laboratoire", new LaboratoireServlet(),freeEngine);
        get("/detailsAtelier", new DetailsAtelierServlet(),freeEngine);
        get("/ajouter", new AjouterModifierAtelierServlet(),freeEngine);
        get("/listAtelier", new ListAtelierServlet(),freeEngine);
        post("/listAtelier", new ListAtelierServlet(),freeEngine); // post réalisé depuis la page /ajouter

        
        
    }
}