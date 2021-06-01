package eus.cic.core.app.connection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONObject;


public class APIutils {
	public static String URL = "http://servkolay.ddns.net";
	public static final int PORT = 8844;

	private static HttpURLConnection getConnection(String url, String method, int port) throws IOException {
		URL urlwport = new URL(URL + ":" + port + url.toString());
		HttpURLConnection connection = (HttpURLConnection) urlwport.openConnection();
		connection.setRequestMethod(method);
		connection.setRequestProperty("Content-Type", "application/json");
		connection.setDoOutput(true);
		connection.setConnectTimeout(5000);
		connection.setReadTimeout(5000);
		return connection;
	}

	private static JSONObject getInputStream(HttpURLConnection httpClient) throws IOException {
		try (BufferedReader in = new BufferedReader(new InputStreamReader(httpClient.getInputStream()))) {
			StringBuilder response = new StringBuilder();
			String line;
			while ((line = in.readLine()) != null) {
				response.append(line);
			}
			return new JSONObject(response.toString()).put("status", "success");
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	private static boolean writeJSON(HttpURLConnection httpClient, JSONObject json) {

		try (OutputStream os = httpClient.getOutputStream()) {
			byte[] input = json.toString().getBytes("utf-8");
			os.write(input, 0, input.length);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public static JSONObject getRequest(String url) {
		try {
			HttpURLConnection httpClient = getConnection(url, "GET", PORT);
			int responseCode = httpClient.getResponseCode();
			System.out.println("Response Code : " + responseCode);
			return getInputStream(httpClient);
		} catch (Exception e) {
			e.printStackTrace();
			return new JSONObject().put("status", "error").put("error", "general");
		}
	}


	public static JSONObject postRequest(String url, JSONObject json) {
		try {
			HttpURLConnection httpClient = getConnection(url, "POST", PORT);

			if (!writeJSON(httpClient, json))
				return new JSONObject().put("status", "error").put("error", "json");

			int responseCode = httpClient.getResponseCode();
			System.out.println("Response Code : " + responseCode);
			return getInputStream(httpClient);
		} catch (Exception e) {
			e.printStackTrace();
			return new JSONObject().put("status", "error").put("error", "general");
		}
	}
	
	public static void serURL(String url) {
		URL = url;
	}
}
