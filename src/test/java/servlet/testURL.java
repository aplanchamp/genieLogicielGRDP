package servlet;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import org.junit.Test;

import static org.junit.Assert.*;

public class testURL {

	@Test
	public void testURL() throws Exception {
	    String strUrl = "http://localhost:4567/";

	    try {
	        URL url = new URL(strUrl);
	        HttpURLConnection urlConn = (HttpURLConnection) url.openConnection();
	        urlConn.connect();

	        assertEquals(HttpURLConnection.HTTP_OK, urlConn.getResponseCode());
	    } catch (IOException e) {
	        System.err.println("Error creating HTTP connection");
	        e.printStackTrace();
	        throw e;
	    }
	}
	
}
