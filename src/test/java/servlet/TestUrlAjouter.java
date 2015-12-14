package servlet;

import static org.junit.Assert.*;
import static spark.Spark.*;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import org.junit.Test;

import freemarker.template.Configuration;
import spark.template.freemarker.FreeMarkerEngine;

public class TestUrlAjouter {
	
	@Test
	public void test() throws IOException {
		// Freemarker configuration
		Configuration cfg = new Configuration(Configuration.VERSION_2_3_22);
		cfg.setDirectoryForTemplateLoading(new File("src/main/resources"));
		cfg.setDefaultEncoding("UTF-8");
    	FreeMarkerEngine freeEngine = new FreeMarkerEngine();
    	freeEngine.setConfiguration(cfg);
    	
		get("/ajouter", new AjouterModifierAtelierServlet(),freeEngine); // define the route
		awaitInitialization();
		
		URL obj = new URL("http://localhost:4567/ajouter");
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("GET");

		// Assert code 200 from HTTP GET request
		assertEquals(HttpURLConnection.HTTP_OK,con.getResponseCode());
		
		con.disconnect();
		
		stop();
	}
}
