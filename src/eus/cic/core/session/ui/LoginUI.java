package eus.cic.core.session.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
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

import ui.components.MDButton;
import ui.components.RoundedJPasswordField;
import ui.components.RoundedTextField;
import interfaces.IRoundButtonListener;

public class LoginUI extends JFrame {
	
	private static final String VERSION = "V0.1.3";
	private static final Color FOREGROUND_COLOR_VERSION = new Color(166, 166, 166);
	private static final Color FOREGROUND_COLOR_USER_PASS = new Color(127, 127, 127);
	private static final Color BACKGROUND_COLOR_USER_PASS = new Color(217, 217, 217);
	private static final Font FONT_VERSION = new Font("Calibri", Font.PLAIN, 10);
	private static final Font FONT_MAIN_LABEL = new Font("Calibri", Font.BOLD, 28);
	private static final Font FONT_USER_PASS = new Font("Calibri", Font.BOLD, 14);
	private static final String LOGO_PATH = "resources/assets/LogoAI_100_100.png";
	private static final String LOGIN_LABEL = "Iniciar Sesion";
	private JTextField userField;
	private JPasswordField passwordField;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginUI frame = new LoginUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public LoginUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(new Dimension(500, 800));
		setLocationRelativeTo(null);
		setContentPane(createContentPane());
	}


	private JPanel createContentPane() {
		JPanel cPanel = new JPanel(new BorderLayout());
		cPanel.setBackground(Color.WHITE);
		cPanel.add(createVersionPane(), BorderLayout.SOUTH);
		cPanel.add(createMainPanel(), BorderLayout.CENTER);
		return cPanel;
	}


	private JPanel createMainPanel() {
		JPanel mainPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 1000, 80));
		mainPanel.setBackground(Color.WHITE);
		mainPanel.add(loadImage());
		mainPanel.add(createLabel());
		mainPanel.add(createFields());
		mainPanel.add(createSubmitButton());
		return mainPanel;
	}


	private JButton createSubmitButton() {
		JButton submit = new MDButton("->", new Dimension(60, 50), MDButton.RED, 40, null, "submit");
		return submit;
	}


	private JPanel createFields() {
		JPanel fieldsPanel = new JPanel(new GridLayout(2, 1, 0, 50));
		
		userField = new RoundedTextField("Username");
		userField.setFont(FONT_USER_PASS);
		userField.setForeground(FOREGROUND_COLOR_USER_PASS);
		userField.setColumns(20);
		userField.setBackground(BACKGROUND_COLOR_USER_PASS);
		
		passwordField = new RoundedJPasswordField("Password");
		passwordField.setFont(FONT_USER_PASS);
		passwordField.setForeground(FOREGROUND_COLOR_USER_PASS);
		passwordField.setColumns(20);
		passwordField.setBackground(BACKGROUND_COLOR_USER_PASS);
		
		fieldsPanel.setBackground(Color.WHITE);
		fieldsPanel.add(userField);
		fieldsPanel.add(passwordField);
		return fieldsPanel;
	}


	private JLabel createLabel() {
		JLabel label = new JLabel(LOGIN_LABEL);
		label.setFont(FONT_MAIN_LABEL);
		return label;
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
				
		Box horizontalBox = Box.createHorizontalBox();
	    horizontalBox.add(Box.createGlue());
	    horizontalBox.add(versionLabel);
	    versioPanel.add(horizontalBox);
		return versioPanel;
	}

}
