package eus.cic.core.app.session;

import org.json.JSONObject;

import eus.cic.core.app.utils.APIRequests;
import eus.cic.core.models.User;

public class SessionHandler {
	private static String session;
	private static Integer userId;
	private static User user;
	private static Integer exit;

	static {
		session = null;
		userId = null;
		exit = 0;
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

	public static User getUser() throws SessionException {
		if (user == null) {
			User user = APIRequests.getUser(userId);
			SessionHandler.user = user;
		}
		return user;
	}

	public static Integer exit() {
		return exit;
	}

	public static void setExit(Integer ex) {
		exit = ex;
	}
}
