package eus.cic.core;

import eus.cic.core.app.main.PrincipalWindow;
import eus.cic.core.app.session.SessionHandler;
import eus.cic.core.app.session.control.LoginController;
import eus.cic.core.models.User;

public class Application {

	public static void main(String[] args) {

		while (SessionHandler.exit() != -1) {
			try {
				SessionHandler.setExit(0);
				LoginController.getLogin();
				User user = SessionHandler.getUser();
				new PrincipalWindow(user);
			} catch (Exception e) {
				e.printStackTrace();
			}
			while (SessionHandler.exit() == 0) {
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void restartApp() {
		try {
			LoginController.getLogin();
			User user = SessionHandler.getUser();
			new PrincipalWindow(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
