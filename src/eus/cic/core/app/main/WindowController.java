package eus.cic.core.app.main;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JPanel;

import eus.cic.core.app.admin.ui.AdminUI;
import eus.cic.core.app.session.SessionHandler;
import eus.cic.core.app.user.ui.UserUI;
import eus.cic.core.models.User;

public class WindowController implements WindowListener {

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
		if (user.isAdmin())
			ui = new AdminUI(window);
		else
			ui = new UserUI(user, window);
	}

	private void setStartView() {
		window.setContentPane(ui);
	}

	@Override
	public void windowOpened(WindowEvent e) {
	}

	@Override
	public void windowClosing(WindowEvent e) {
	}

	@Override
	public void windowClosed(WindowEvent e) {

		if (SessionHandler.exit() != 1) {
			SessionHandler.setExit(-1);
		}
	}

	@Override
	public void windowIconified(WindowEvent e) {
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
	}

	@Override
	public void windowActivated(WindowEvent e) {
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
	}
}