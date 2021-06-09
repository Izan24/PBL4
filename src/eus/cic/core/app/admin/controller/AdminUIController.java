package eus.cic.core.app.admin.controller;

import eus.cic.core.app.admin.ui.AdminUI;
import eus.cic.core.app.admin.ui.building.AdminBuildingUI;
import eus.cic.core.app.admin.ui.menu.AdminMenuUI;
import eus.cic.core.app.interfaces.IRoundButtonListener;
import eus.cic.core.app.main.PrincipalWindow;

public class AdminUIController implements IRoundButtonListener {

	AdminUI ui;

	private PrincipalWindow window;
	AdminBuildingUI buildingUI;
	AdminMenuUI menuUI;

	public AdminUIController(AdminUI ui, PrincipalWindow window) {
		this.ui = ui;
		this.window = window;

		setUISToNull();
		setStartUI();
	}

	private void setStartUI() {
		this.menuUI = new AdminMenuUI(this);
		ui.setStartPannel(menuUI);
	}

	private void setUISToNull() {
		buildingUI = null;
	}

	@Override
	public void actionPerformed(String actionCommand) {
		if (actionCommand.equals(AdminUIControllerAC.MENU)) {
			System.out.println("a");
			ui.setCenterPanel(menuUI);
		}
	}

	public void setCenterUI(String command) {
		switch (command) {
		case AdminUIControllerAC.BUILDINGS:
			if (buildingUI == null) {
				buildingUI = new AdminBuildingUI(window);
			}
			ui.enableHome();
			ui.setCenterPanel(buildingUI);
			break;
		case AdminUIControllerAC.ROOMS:
			ui.enableHome();

			break;
		case AdminUIControllerAC.WORKERS:
			ui.enableHome();

			break;
		case AdminUIControllerAC.PROJECTS:
			ui.enableHome();

			break;
		case AdminUIControllerAC.CARDS:
			ui.enableHome();

			break;
		case AdminUIControllerAC.BOOKINGS:
			ui.enableHome();

			break;
		case AdminUIControllerAC.PERMISSIONS:
			ui.enableHome();

			break;
		case AdminUIControllerAC.CHECKINS:
			ui.enableHome();

			break;
		case AdminUIControllerAC.BONDS:
			ui.enableHome();

			break;
		default:
			break;

		}

	}

}
