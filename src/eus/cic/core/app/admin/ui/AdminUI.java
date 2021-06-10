package eus.cic.core.app.admin.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.plaf.basic.BasicButtonUI;

import eus.cic.core.app.admin.controller.AdminUIController;
import eus.cic.core.app.admin.controller.AdminUIControllerAC;
import eus.cic.core.app.admin.controller.building.AdminBuildingController;
import eus.cic.core.app.admin.controller.menu.AdminMenuController;
import eus.cic.core.app.admin.ui.building.AdminBuildingUI;
import eus.cic.core.app.admin.ui.menu.AdminMenuUI;
import eus.cic.core.app.main.PrincipalWindow;
import eus.cic.core.app.uicomponents.components.MDButton;

public class AdminUI extends JPanel {

	public static final String ADMIN_STRING = "Administrador";
	public static final String MENU_STRING = "Menu";
	public static final Font FONT = new Font("Calibri", Font.PLAIN, 22);
	public static final Color BG_COLOR = Color.WHITE;
	public static final Color HOME_COLOR = new Color(46, 117, 182);

	public JPanel toolbar;
	public JButton homeButton;
	private AdminUIController controller;

	public AdminUI(PrincipalWindow window) {
		super(new BorderLayout());
		this.setBackground(BG_COLOR);
		this.setBorder(new EmptyBorder(20, 20, 20, 20));

		controller = new AdminUIController(this, window);
		initHomeButton();
		this.add(createAdminToolbar(), BorderLayout.NORTH);

		this.repaint();
		this.revalidate();
	}

	public void setCenterPanel(JPanel centerPanel) {
		this.removeAll();
		this.add(toolbar, BorderLayout.NORTH);
		this.add(centerPanel, BorderLayout.CENTER);
		this.revalidate();
		this.repaint();
	}

	public void enableHome() {
		homeButton.setVisible(true);
		homeButton.setEnabled(true);
	}

	public void disableHome() {
		homeButton.setVisible(false);
		homeButton.setEnabled(false);
	}

	private void initHomeButton() {
		homeButton = new MDButton(MENU_STRING, new Dimension(100, 30), HOME_COLOR, 10, controller,
				AdminUIControllerAC.MENU);
	}

	private JPanel createAdminToolbar() {
		toolbar = new JPanel(new BorderLayout());
		JPanel tempPanel = new JPanel();
		toolbar.setPreferredSize(new Dimension(250, 44));
		toolbar.setBackground(BG_COLOR);
		tempPanel.add(createAdminButton());
		tempPanel.setBorder(BorderFactory.createEmptyBorder(0,0,0,105));
		tempPanel.setBackground(BG_COLOR);
		toolbar.add(tempPanel, BorderLayout.CENTER);
		toolbar.add(homeButton, BorderLayout.WEST);
		toolbar.setBorder(new MatteBorder(0, 0, 1, 0, Color.LIGHT_GRAY));
		return toolbar;
	}

	private JButton createAdminButton() {
		JButton tempButton = new JButton(ADMIN_STRING);
		tempButton.setBackground(BG_COLOR);
		tempButton.setFont(FONT);
		tempButton.setFocusable(false);
		tempButton.setUI(new BasicButtonUI());
		tempButton.setPreferredSize(new Dimension(250, 40));
		tempButton.setBorder(BorderFactory.createMatteBorder(0, 0, 4, 0, MDButton.RED));
		return tempButton;
	}

	public void setStartPannel(AdminMenuUI menuUI) {
		this.add(menuUI, BorderLayout.CENTER);
	}

}
