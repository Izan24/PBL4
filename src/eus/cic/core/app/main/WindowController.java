package eus.cic.core.app.main;

import javax.swing.JPanel;

import eus.cic.core.app.admin.ui.AdminUI;
import eus.cic.core.app.user.ui.UserUI;
import eus.cic.core.models.User;

public class WindowController {

	PrincipalWindow window;
	JPanel ui;
	User user;

	public WindowController(PrincipalWindow window, User user) {
		this.user = user;
		this.window = window;
		initUI();
		setStartView();
		window.repaint();
		window.revalidate();
	}

	private void initUI() {
		if (user.isAdmin()) ui = new AdminUI();
		else ui = new UserUI();
	}

	private void setStartView() {
		window.setContentPane(ui);
		//window.setContentPane(new UserUI());
	}
}
