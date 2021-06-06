package eus.cic.core.app.admin.controller.building;

import eus.cic.core.app.admin.ui.building.AdminBuildingUI;
import eus.cic.core.app.interfaces.IClickable;
import eus.cic.core.app.interfaces.IRoundButtonListener;
import eus.cic.core.app.main.PrincipalWindow;
import eus.cic.core.app.uicomponents.dialogs.CreationErrorDialog;
import eus.cic.core.models.Building;

public class AdminBuildingController implements IRoundButtonListener, IClickable {

	Building oldBuilding;
	AdminBuildingUI ui;
	PrincipalWindow window;

	private final String ERROR_MSG = "Los campos introducidos no son validos";
	private final String EQUAL_MSG = " \"No has realizado ningun cambio\"";

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
			try {
				ui.setNameField(oldBuilding.getNombre());
				ui.setPostalCodeField(oldBuilding.getPostalCode());
			} catch (NullPointerException e) {
			}

			break;
		}
	}

	private void addBuilding() {

		if (checkValues()) {
			Building newBuilding = new Building(ui.getPostalCode(), ui.getName());

			if (oldBuilding != null) {
				if (!oldBuilding.equals(newBuilding)) {
					ui.updateBuilding(oldBuilding, newBuilding);
					ui.resetFields();
					oldBuilding = null;
				} else {
					new CreationErrorDialog(window, "Error: iguales", true, EQUAL_MSG);
				}
			} else {
				ui.addBuilding(newBuilding);
				ui.resetFields();
			}
		} else {
			new CreationErrorDialog(window, "Error: campos", true, ERROR_MSG);
		}
	}

	private boolean checkValues() {
		Boolean valid = true;

		if (ui.getName().replaceAll("\\s", "").equals("") || ui.getPostalCode().replaceAll("\\s", "").equals(""))
			valid = false;

		return valid;
	}

	@Override
	public void clicked() {
		oldBuilding = ui.getSelectedValue();
		ui.setNameField(oldBuilding.getNombre());
		ui.setPostalCodeField(oldBuilding.getPostalCode());
	}

}
