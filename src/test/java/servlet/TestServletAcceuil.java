package servlet;

import static org.junit.Assert.*;
import static spark.Spark.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

import org.junit.Test;

import freemarker.template.Configuration;
import spark.template.freemarker.FreeMarkerEngine;

public class TestServletAcceuil {

	@Test
	public void test() throws IOException {
		
    	Configuration config = new Configuration();
    	config.setDirectoryForTemplateLoading(new File("src/main/resources"));
    	config.setDefaultEncoding("UTF-8");
    	FreeMarkerEngine freeEngine = new FreeMarkerEngine();
    	freeEngine.setConfiguration(config);
		
		get("/accueil", new AccueilServlet(),freeEngine);

		awaitInitialization();

		StringBuilder result = new StringBuilder();
		
		URL obj = new URL("http://localhost:4567/accueil");
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("GET");
		
		BufferedReader rd = new BufferedReader(new InputStreamReader(con.getInputStream()));
		
		String line = rd.readLine();	
		rd.close();

		String content = new Scanner(new File("src/main/resources/accueil.ftl")).useDelimiter("\n").next();	
		assertEquals(line, content);
		
		
		con.disconnect();
		
		stop();
		
	}

}
