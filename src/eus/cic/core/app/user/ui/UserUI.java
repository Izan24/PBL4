package eus.cic.core.app.user.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.MatteBorder;

import eus.cic.core.app.lists.room.RoomList;
import eus.cic.core.app.uicomponents.components.MDButtonPanel;
import eus.cic.core.app.user.controller.UserUIController;
import eus.cic.core.app.user.ui.profile.UserProfileUI;
import eus.cic.core.models.Room;
import eus.cic.core.models.User;

public class UserUI extends JPanel {

	private UserUIController controller;

	private JPanel toolbar;
	public static final Font FONT = new Font("Calibri", Font.PLAIN, 22);
	public static final Color BG_COLOR = Color.WHITE;

	public UserUI(User user) {
		super(new BorderLayout());
		controller = new UserUIController(this, user);
		this.setBackground(BG_COLOR);
		this.add(createUserToolbar(), BorderLayout.NORTH);

		// List<Room> list = new ArrayList<>();
		// list.add(new Room("description", "1", "2", true));
		// list.add(new Room("descrption", "4", "3", true));

		// this.add(new UserProfileUI(new User("p", "e", "r", "23", "45", "5555", "77@",
		// "departamento", "dni", false, list)), BorderLayout.CENTER);

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

	private JPanel createUserToolbar() {
		toolbar = new JPanel();
		toolbar.setPreferredSize(new Dimension(250, 44));
		toolbar.setBackground(BG_COLOR);
		toolbar.add(new MDButtonPanel(controller));
		toolbar.setBorder(new MatteBorder(0, 0, 1, 0, Color.LIGHT_GRAY));
		return toolbar;
	}

	public void setStartUI(JPanel startPanel) {
		this.add(startPanel, BorderLayout.CENTER);
	}

}
