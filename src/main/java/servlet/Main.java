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
	
	private static final String USER_SESSION_ID = "user";

	
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
        before("/accueil", (req, res) -> {
			String user = getAuthenticatedUser(req);
			if(user != null && req.queryParams("disconnect") == null && req.queryParams("contacts")==null && req.queryParams("faq") == null && req.queryParams("historique") == null) {
				res.redirect("/laboratoire");
				halt(401, "Go away!");
			}
		});
        post("/accueil", new AccueilServlet(),freeEngine);
        get("/laboratoire", new LaboratoireServlet(),freeEngine);
		before("/laboratoire", (req, res) -> {
			String user = getAuthenticatedUser(req);
			if(user == null) {
				res.redirect("/accueil");
				halt(401, "Go away!");
			}
		});
        get("/detailsAtelier", new DetailsAtelierServlet(),freeEngine);
		before("/detailsAtelier", (req, res) -> {
			String user = getAuthenticatedUser(req);
			if(user == null) {
				res.redirect("/accueil");
				halt(401, "Go away!");
			}
		});
        get("/ajouter", new AjouterModifierAtelierServlet(),freeEngine);
		before("/ajouter", (req, res) -> {
			String user = getAuthenticatedUser(req);
			if(user == null) {
				res.redirect("/accueil");
				halt(401, "Go away!");
			}
		});
        get("/listAtelier", new ListAtelierServlet(),freeEngine);
        post("/ajouter", new AjouterModifierAtelierServlet(),freeEngine); // post réalisé depuis la page /ajouter
        post("/listAtelier", new ListAtelierServlet(),freeEngine); // post réalisé depuis la page /ajouter
        post("/modifier", new AjouterModifierAtelierServlet(), freeEngine); // post vers la modification d'atelier
        get("/modifier", new AjouterModifierAtelierServlet(), freeEngine); // post vers la modification d'atelier
        get("/delete",new AjouterModifierAtelierServlet(),freeEngine );


        
        
    }
    
	private static String getAuthenticatedUser(Request request) {
		if(!request.session().attributes().isEmpty()){
			return request.session().attributes().iterator().next();
		}
		else 
			return null;
	}
	
}