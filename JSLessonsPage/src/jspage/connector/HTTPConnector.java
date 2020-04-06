package jspage.connector;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import jspage.bean.Page;



public class HTTPConnector {
	  	private static HttpURLConnection connection = null;

	    public static void openConnectionGet(String query) throws MalformedURLException, IOException {
	        connection = (HttpURLConnection) new URL(query).openConnection();
	        connection.setRequestMethod("GET");
	        connection.connect();
	    }

	    public static void openConnectionPost(String query, String body) throws MalformedURLException, IOException {
	        connection = (HttpURLConnection) new URL(query).openConnection();
	        connection.setRequestMethod("POST");
	        connection.setRequestProperty("Accept-Language", "UTF-8");

	        connection.setDoOutput(true);
	        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(connection.getOutputStream());
	        outputStreamWriter.write(body);
	        outputStreamWriter.flush();
	    }

	    public static void closeConnection() {
	        if (connection != null) {
	            connection.disconnect();
	        }
	    }

	    public static boolean connectionIsSuccsessful() throws IOException {
	        if (HttpURLConnection.HTTP_OK == connection.getResponseCode()) {
	            return true;
	        }
	        return false;
	    }

	    public static StringBuilder readContent() throws IOException {
	        StringBuilder builder = new StringBuilder();
	        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
	        String line;
	        while ((line = reader.readLine()) != null) {
	            builder.append(line);
	        }
	        reader.close();
	        return builder;
	    }
}
