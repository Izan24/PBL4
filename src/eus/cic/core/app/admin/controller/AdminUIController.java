package eus.cic.core.app.admin.controller;

import eus.cic.core.app.admin.ui.AdminUI;
import eus.cic.core.app.admin.ui.building.AdminBuildingUI;
import eus.cic.core.app.admin.ui.menu.AdminMenuUI;
import eus.cic.core.app.interfaces.IRoundButtonListener;
import eus.cic.core.app.main.PrincipalWindow;
import eus.cic.core.app.uicomponents.dialogs.CreationErrorDialog;

public class AdminUIController implements IRoundButtonListener {

	AdminUI ui;

	private PrincipalWindow window;
	AdminBuildingUI buildingUI;
	AdminMenuUI menuUI;

	private static final String ERROR_MSG = "Esta funcionalidad no se ha implementado todavia";

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
			new CreationErrorDialog(window, "Alerta: no implementado", true, ERROR_MSG);

			break;
		case AdminUIControllerAC.WORKERS:
			new CreationErrorDialog(window, "Alerta: no implementado", true, ERROR_MSG);

			break;
		case AdminUIControllerAC.PROJECTS:
			new CreationErrorDialog(window, "Alerta: no implementado", true, ERROR_MSG);

			break;
		case AdminUIControllerAC.CARDS:
			new CreationErrorDialog(window, "Alerta: no implementado", true, ERROR_MSG);

			break;
		case AdminUIControllerAC.BOOKINGS:
			new CreationErrorDialog(window, "Alerta: no implementado", true, ERROR_MSG);

			break;
		case AdminUIControllerAC.PERMISSIONS:
			new CreationErrorDialog(window, "Alerta: no implementado", true, ERROR_MSG);

			break;
		case AdminUIControllerAC.CHECKINS:
			new CreationErrorDialog(window, "Alerta: no implementado", true, ERROR_MSG);

			break;
		case AdminUIControllerAC.BONDS:
			new CreationErrorDialog(window, "Alerta: no implementado", true, ERROR_MSG);

			break;
		default:
			break;

		}

	}

}
