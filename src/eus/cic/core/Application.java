package eus.cic.core;

import eus.cic.core.app.main.PrincipalWindow;
import eus.cic.core.app.session.SessionHandler;
import eus.cic.core.app.session.control.LoginController;
import eus.cic.core.models.User;

public class Application {

	public static void main(String[] args) {
		try {
			LoginController.getLogin();
			User user = SessionHandler.getUser();
			new PrincipalWindow(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
