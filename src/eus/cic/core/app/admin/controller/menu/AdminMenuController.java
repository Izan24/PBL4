package eus.cic.core.app.admin.controller.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import eus.cic.core.app.admin.controller.AdminUIController;
import eus.cic.core.app.admin.ui.menu.AdminMenuUI;
import eus.cic.core.app.interfaces.IRoundButtonListener;

public class AdminMenuController implements IRoundButtonListener {

	AdminMenuUI adminMenuUI;
	AdminUIController uiController;

	public AdminMenuController(AdminMenuUI adminMenuUI, AdminUIController uiController) {
		this.adminMenuUI = adminMenuUI;
		this.uiController = uiController;

	}

	@Override
	public void actionPerformed(String actionCommand) {

		switch (actionCommand) {

		case AdminMenuControllerAC.BUILDINGS:
			uiController.setCenterUI(AdminMenuControllerAC.BUILDINGS);
			break;

		case AdminMenuControllerAC.ROOMS:
			uiController.setCenterUI(AdminMenuControllerAC.ROOMS);
			break;

		case AdminMenuControllerAC.WORKERS:
			uiController.setCenterUI(AdminMenuControllerAC.WORKERS);
			break;

		case AdminMenuControllerAC.BOOKINGS:
			uiController.setCenterUI(AdminMenuControllerAC.BOOKINGS);
			break;

		case AdminMenuControllerAC.CARDS:
			uiController.setCenterUI(AdminMenuControllerAC.CARDS);
			break;

		case AdminMenuControllerAC.PERMISSIONS:
			uiController.setCenterUI(AdminMenuControllerAC.PERMISSIONS);
			break;

		case AdminMenuControllerAC.PROJECTS:
			uiController.setCenterUI(AdminMenuControllerAC.PROJECTS);
			break;

		case AdminMenuControllerAC.CHECKINS:
			uiController.setCenterUI(AdminMenuControllerAC.CHECKINS);
			break;

		case AdminMenuControllerAC.BONDS:
			uiController.setCenterUI(AdminMenuControllerAC.BONDS);
			break;

		default:
			break;
		}
	}

}
