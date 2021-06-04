package eus.cic.core.app.main;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

import eus.cic.core.models.User;

public class PrincipalWindow extends JFrame {

	WindowController windowController;

	public PrincipalWindow(User user) {
		super();
		initWindow();
		windowController = new WindowController(this, user);
	}

	private void initWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(new Dimension(1376, 768));
		setLocationRelativeTo(null);
		setVisible(true);
	}

	public void setWindowView(JPanel viewPanel) {
		this.setContentPane(viewPanel);
	}
	
}
