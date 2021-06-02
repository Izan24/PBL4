package eus.cic.core.app.session;

public class SessionHandler {
	private static String session;
	private static Integer userId;

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
}
