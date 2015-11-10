package servlet;

import static org.junit.Assert.*;
import static spark.Spark.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.junit.Test;

public class TestDetailsAtelier {

	@Test
	public void test() throws IOException {
		
		get("/detailsAtelier", new DetailsAtelierServlet());

		awaitInitialization();

		StringBuilder result = new StringBuilder();
		
		URL obj = new URL("http://localhost:4567/detailsAtelier");
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("GET");
		
		BufferedReader rd = new BufferedReader(new InputStreamReader(con.getInputStream()));
		
		String line;
		while ((line = rd.readLine()) != null) {
			result.append(line);
		}
		
		rd.close();
		assertEquals(result.toString(),"details atelier");
		
		
		con.disconnect();
		
		stop();
		
	}

}
