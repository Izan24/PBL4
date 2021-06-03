package eus.cic.core;

import eus.cic.core.app.session.SessionHandler;
import eus.cic.core.app.session.control.LoginController;
import eus.cic.core.models.User;

public class Application {

	public static void main(String[] args) {
		LoginController.getLogin();
		User user = SessionHandler.getUser();
		//PrincipalWindow win = new PrincipalWindow();
	}

}
