package eus.cic.core.app.session;

import org.json.JSONObject;

import eus.cic.core.app.connection.APIutils;
import eus.cic.core.app.utils.JSONParser;
import eus.cic.core.models.User;

public class SessionHandler {
	private static String session;
	private static Integer userId;
	private static User user;

	static {
		session = null;
		userId = null;
	}

	public static String getSession() {
		return session;
	}

	public static Integer getUserId() {
		return userId;
	}

	public static void setSession(String session, Integer userId) {
		SessionHandler.session = session;
		SessionHandler.userId = userId;
	}
	
	public static JSONObject getSessionCredentials() {
		JSONObject json = new JSONObject();
		json.put("session", session);
		json.put("user_id", userId);
		return json;
	}
	
	public static User getUser() {
		if (user == null) {
			JSONObject json = APIutils.getRequest(String.format("/api/getUserById?id=%d&session=%s", userId, session));
			User user = JSONParser.parseUser(json);
			SessionHandler.user = user;
		}
		return user;
	}
}
