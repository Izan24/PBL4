package eus.cic.core.app.user.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.border.MatteBorder;

import eus.cic.core.app.uicomponents.components.MDButtonPanel;
import eus.cic.core.app.user.controller.UserUIController;

public class UserUI extends JPanel {
	
	private UserUIController controller;
	
	private JPanel toolbar;
	public static final Font FONT = new Font("Calibri", Font.PLAIN, 22);
	public static final Color BG_COLOR = Color.WHITE;

	public UserUI() {
		super(new BorderLayout());
		controller = new UserUIController(this);
		this.setBackground(BG_COLOR);
		this.add(createUserToolbar());
		this.repaint();
		this.revalidate();
	}
	
	public void setCenterPanel(JPanel centerPanel) {
		this.add(centerPanel, BorderLayout.CENTER);
		this.revalidate();
		this.repaint();
	}
	
	
	private JPanel createUserToolbar() {
		toolbar = new JPanel();
		toolbar.setPreferredSize(new Dimension(250, 44));
		toolbar.setBackground(BG_COLOR);
		toolbar.add(new MDButtonPanel(controller));
		toolbar.setBorder(new MatteBorder(0, 0, 1, 0, Color.LIGHT_GRAY));
		return toolbar;
	}
	
	
}
