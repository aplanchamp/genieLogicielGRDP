package servlet;

import static spark.Spark.*;

import spark.Request;
import spark.Response;

public class Main {
	
    public static void main(String[] args) {
    	
    	// Redirection vers la servlet accueil
    	get("/",(Request req,Response resp)->{
    		resp.redirect("/accueil");
    		return null;
    	});    	
        get("/accueil", new AcceuilServlet());
        get("/laboratoire", new LaboratoireServlet());
        get("/detailsAtelier", new DetailsAtelierServlet());
        get("/ajouter", new AjouterModifierAtelierServlet());
        
    }
}