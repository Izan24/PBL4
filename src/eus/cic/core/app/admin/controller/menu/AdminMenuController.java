package eus.cic.core.app.admin.controller.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import eus.cic.core.app.admin.ui.menu.AdminMenu;
import eus.cic.core.app.interfaces.IRoundButtonListener;

public class AdminMenuController implements ActionListener {

	AdminMenu adminMenuUI;

	public AdminMenuController(AdminMenu adminMenuUI) {
		this.adminMenuUI = adminMenuUI;

	}

	@Override
	public void actionPerformed(ActionEvent event) {

		switch (event.getActionCommand()) {

		case AdminMenuControllerAC.BUILDINGS:
			System.out.println(event.getActionCommand());
			break;

		case AdminMenuControllerAC.ROOMS:
			System.out.println(event.getActionCommand());
			break;

		case AdminMenuControllerAC.WORKERS:
			System.out.println(event.getActionCommand());
			break;

		case AdminMenuControllerAC.BOOKINGS:
			System.out.println(event.getActionCommand());
			break;

		case AdminMenuControllerAC.CARDS:
			System.out.println(event.getActionCommand());
			break;

		case AdminMenuControllerAC.PERMISSIONS:
			System.out.println(event.getActionCommand());
			break;

		case AdminMenuControllerAC.PROJECTS:
			System.out.println(event.getActionCommand());
			break;

		case AdminMenuControllerAC.CHECKINS:
			System.out.println(event.getActionCommand());
			break;

		case AdminMenuControllerAC.BONDS:
			System.out.println(event.getActionCommand());
			break;

		default:
			break;
		}

	}

}
