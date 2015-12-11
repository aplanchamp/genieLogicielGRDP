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

	    // general get sur l'URL
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
	    // get sur l'URL accueil 
	    try { 
	        URL url = new URL(strUrl+"accueil");
	        HttpURLConnection urlConn = (HttpURLConnection) url.openConnection();
	        urlConn.connect();
	        assertEquals(HttpURLConnection.HTTP_OK, urlConn.getResponseCode());
	    		
	    } catch (IOException e){
	        System.err.println("Error creating HTTP connection on accueil");
	        e.printStackTrace();
	        throw e;
	    }
	    // get sur l'URL detailsatelier 
	    try { 
	        URL url = new URL(strUrl+"detailsAtelier");
	        HttpURLConnection urlConn = (HttpURLConnection) url.openConnection();
	        urlConn.connect();
	        assertEquals(HttpURLConnection.HTTP_OK, urlConn.getResponseCode());
	    		
	    } catch (IOException e){
	        System.err.println("Error creating HTTP connection on detailsAtelier");
	        e.printStackTrace();
	        throw e;
	    }
	    // get sur l'URL laboratoire
	    try { 
	        URL url = new URL(strUrl+"laboratoire");
	        HttpURLConnection urlConn = (HttpURLConnection) url.openConnection();
	        urlConn.connect();
	        assertEquals(HttpURLConnection.HTTP_OK, urlConn.getResponseCode());
	    		
	    } catch (IOException e){
	        System.err.println("Error creating HTTP connection on laboratoire");
	        e.printStackTrace();
	        throw e;
	    }
	    // get sur l'URL ajouter 
	    try { 
	        URL url = new URL(strUrl+"ajouter");
	        HttpURLConnection urlConn = (HttpURLConnection) url.openConnection();
	        urlConn.connect();
	        assertEquals(HttpURLConnection.HTTP_OK, urlConn.getResponseCode());
	    		
	    } catch (IOException e){
	        System.err.println("Error creating HTTP connection on ajouter");
	        e.printStackTrace();
	        throw e;
	    }
	    // get sur l'URL listAtelier 
	    try { 
	        URL url = new URL(strUrl+"listAtelier");
	        HttpURLConnection urlConn = (HttpURLConnection) url.openConnection();
	        urlConn.connect();
	        assertEquals(HttpURLConnection.HTTP_OK, urlConn.getResponseCode());
	    		
	    } catch (IOException e){
	        System.err.println("Error creating HTTP connection on listAtelier");
	        e.printStackTrace();
	        throw e;
	    }
	}
	
}
