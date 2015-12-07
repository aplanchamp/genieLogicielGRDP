package servlet;

import static org.junit.Assert.*;
import static spark.Spark.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import org.junit.Test;

import freemarker.template.Configuration;
import spark.template.freemarker.FreeMarkerEngine;

public class TestDetailsAtelier {

	@Test
	public void test() throws IOException {
		// Freemarker configuration
		Configuration cfg = new Configuration(Configuration.VERSION_2_3_22);
		cfg.setDirectoryForTemplateLoading(new File("src/main/resources"));
		cfg.setDefaultEncoding("UTF-8");
    	FreeMarkerEngine freeEngine = new FreeMarkerEngine();
    	freeEngine.setConfiguration(cfg);
    	
		get("/detailsAtelier", new DetailsAtelierServlet(),freeEngine); // define the route
		awaitInitialization();
		
		StringBuilder result = new StringBuilder();
		URL obj = new URL("http://localhost:4567/detailsAtelier");
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("GET");

		// Assert code 200 from HTTP GET request
		assertEquals(200,con.getResponseCode());
		
		con.disconnect();
		
		stop();
		
		


	}

}
