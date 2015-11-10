package servlet;

import static org.junit.Assert.*;
import static spark.Spark.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.junit.Test;

public class TestServletAcceuil {

	@Test
	public void test() throws IOException {
		
		get("/accueil", new AcceuilServlet());

		awaitInitialization();

		StringBuilder result = new StringBuilder();
		
		URL obj = new URL("http://localhost:4567/accueil");
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("GET");
		
		BufferedReader rd = new BufferedReader(new InputStreamReader(con.getInputStream()));
		
		String line;
		while ((line = rd.readLine()) != null) {
			result.append(line);
		}
		
		rd.close();
		assertEquals(result.toString(),"foo");
		
		
		con.disconnect();
		
		stop();
		
	}

}
