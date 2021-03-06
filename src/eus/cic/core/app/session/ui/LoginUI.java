package eus.cic.core.app.session.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import eus.cic.core.app.session.control.LoginController;
import eus.cic.core.app.uicomponents.borders.SearchBorder;
import eus.cic.core.app.uicomponents.components.MDButton;
import eus.cic.core.app.uicomponents.components.RoundedJPasswordField;
import eus.cic.core.app.uicomponents.components.RoundedTextField;

public class LoginUI extends JFrame {

	private static final long serialVersionUID = -7388184229618270783L;

	private static final String VERSION = "V0.1.3";
	private static final Color FOREGROUND_COLOR_VERSION = new Color(166, 166, 166);
	private static final Color FOREGROUND_COLOR_TEXT = new Color(38, 38, 38);

	private static final Font FONT_VERSION = new Font("Calibri", Font.PLAIN, 12);
	private static final Font FONT_MAIN_LABEL = new Font("Calibri", Font.BOLD, 28);
	private static final Font FONT_USER_PASS = new Font("Calibri", Font.BOLD, 18);

	private static final String LOGO_PATH = "resources/assets/LogoAI_100_100.png";

	private static final String LOGIN_LABEL = "Iniciar Sesion";

	private JTextField userField;
	private JPasswordField passwordField;
	private LoginController listener;

	public LoginUI(LoginController listener) {
		this.listener = listener;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(new Dimension(500, 700));
		setLocationRelativeTo(null);
		setContentPane(createContentPane());
		this.repaint();
		this.revalidate();
	}

	private JPanel createContentPane() {
		JPanel cPanel = new JPanel(new BorderLayout());
		cPanel.setBackground(Color.WHITE);
		cPanel.add(createVersionPane(), BorderLayout.SOUTH);
		cPanel.add(createMainPanel(), BorderLayout.CENTER);
		return cPanel;
	}

	private JPanel createMainPanel() {
		JPanel mainPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 1000, 70));
		mainPanel.setBackground(Color.WHITE);
		mainPanel.add(loadImage());
		mainPanel.add(createLabel());
		mainPanel.add(createFields());
		mainPanel.add(createSubmitButton());
		return mainPanel;
	}

	private JButton createSubmitButton() {
		JButton submit = new MDButton("Login", new Dimension(80, 50), MDButton.RED, 40, listener, "submit");
		submit.setFocusable(true);
		submit.grabFocus();
		submit.requestFocus();
		submit.addKeyListener(listener);
		return submit;
	}

	private JPanel createFields() {
		JPanel fieldsPanel = new JPanel(new GridLayout(2, 1, 0, 50));

		userField = new RoundedTextField("Usuario");
		userField.setFont(FONT_USER_PASS);
		userField.setForeground(FOREGROUND_COLOR_TEXT);
		userField.setColumns(20);
		userField.setBackground(Color.WHITE);
		userField.setPreferredSize(new Dimension(100, 45));
		userField.setBorder(new SearchBorder(10, FOREGROUND_COLOR_VERSION, false));
		userField.addKeyListener(listener);

		passwordField = new RoundedJPasswordField("Contrase???a");
		passwordField.setFont(FONT_USER_PASS);
		passwordField.setForeground(FOREGROUND_COLOR_VERSION);
		passwordField.setColumns(20);
		passwordField.setBackground(Color.WHITE);
		passwordField.setBorder(new SearchBorder(10, FOREGROUND_COLOR_VERSION, false));
		passwordField.addKeyListener(listener);

		fieldsPanel.setBackground(Color.WHITE);
		fieldsPanel.add(userField);
		fieldsPanel.add(passwordField);
		return fieldsPanel;
	}

	private JLabel createLabel() {
		JLabel label = new JLabel(LOGIN_LABEL);
		label.setFont(FONT_MAIN_LABEL);
		label.setForeground(FOREGROUND_COLOR_TEXT);
		return label;
	}

	public String getUser() {
		return userField.getText();
	}

	public String getPassword() {
		return String.valueOf(passwordField.getPassword());
	}

	private JLabel loadImage() {
		BufferedImage logo;
		JLabel logoLabel = null;
		try {
			logo = ImageIO.read(new File(LOGO_PATH));
			logoLabel = new JLabel(new ImageIcon(logo));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return logoLabel;
	}

	private JPanel createVersionPane() {
		JPanel versioPanel = new JPanel(new BorderLayout());
		JLabel versionLabel = new JLabel(VERSION);
		versionLabel.setForeground(FOREGROUND_COLOR_VERSION);
		versionLabel.setFont(FONT_VERSION);
		versionLabel.setBorder(new EmptyBorder(5, 10, 5, 10));

		Box horizontalBox = Box.createHorizontalBox();
		horizontalBox.add(Box.createGlue());
		horizontalBox.add(versionLabel);
		versioPanel.add(horizontalBox);
		versioPanel.setBackground(Color.WHITE);
		return versioPanel;
	}

}
