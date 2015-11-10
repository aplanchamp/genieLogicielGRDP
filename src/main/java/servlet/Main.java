package servlet;

import static spark.Spark.*;

public class Main {
	
    public static void main(String[] args) {
    	
        get("/accueil", new AcceuilServlet());
        get("/laboratoire", (req, res) -> "Coucou World");
        get("/detailAtelier", (req, res) -> "Coucou World");
        get("/ajouter", (req, res) -> "Coucou World");
        
    }
}