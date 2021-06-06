package eus.cic.core.app.admin.controller.building;

import eus.cic.core.app.admin.ui.building.AdminBuildingUI;
import eus.cic.core.app.interfaces.IClickable;
import eus.cic.core.app.interfaces.IRoundButtonListener;
import eus.cic.core.app.main.PrincipalWindow;
import eus.cic.core.app.uicomponents.dialogs.CreationErrorDialog;
import eus.cic.core.models.Building;

public class AdminBuildingController implements IRoundButtonListener, IClickable {

	AdminBuildingUI ui;
	Building oldBuilding;
	PrincipalWindow window;

	public AdminBuildingController(AdminBuildingUI ui, PrincipalWindow window) {
		this.ui = ui;
		this.window = window;
		oldBuilding = null;
	}

	@Override
	public void actionPerformed(String actionCommand) {
		switch (actionCommand) {
		case AdminBuildingControllerAC.ADD_BUILDING:
			addBuilding();
			break;
		case AdminBuildingControllerAC.REMOVE_BUILDING:
			ui.removeBuilding();
			break;
		case AdminBuildingControllerAC.EDIT_BUILDING:
			oldBuilding = ui.getSelectedValue();
			ui.setNameField(oldBuilding.getNombre());
			ui.setPostalCodeField(oldBuilding.getPostalCode());

			break;
		}
	}

	// TODO: Hcer una comprobacion de que no esté vacio y que no sea el texto
	// default
	private void addBuilding() {

		if (checkValues()) {
			Building newBuilding = new Building(ui.getPostalCode(), ui.getName());

			if (oldBuilding != null) {
				if (!oldBuilding.equals(newBuilding)) {
					ui.updateValue(oldBuilding, newBuilding);
					oldBuilding = null;
				}
			} else {
				ui.addBuilding(newBuilding);
			}
		} else {
			// Error dialog
			new CreationErrorDialog(window, "Error: conexion", true, "Error de prueba");
			System.out.println("Error dialog");
		}

	}

	private boolean checkValues() {
		return false;
	}

	@Override
	public void clicked() {
		oldBuilding = ui.getSelectedValue();
		ui.setNameField(oldBuilding.getNombre());
		ui.setPostalCodeField(oldBuilding.getPostalCode());
	}

}
