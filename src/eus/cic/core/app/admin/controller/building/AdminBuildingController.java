package eus.cic.core.app.admin.controller.building;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import eus.cic.core.app.admin.ui.building.AdminBuildingUI;
import eus.cic.core.app.interfaces.IClickable;
import eus.cic.core.app.interfaces.IRoundButtonListener;
import eus.cic.core.app.main.PrincipalWindow;
import eus.cic.core.app.uicomponents.dialogs.CreationErrorDialog;
import eus.cic.core.models.Building;

public class AdminBuildingController implements IRoundButtonListener, IClickable, KeyListener {

	Building oldBuilding;
	AdminBuildingUI ui;
	PrincipalWindow window;

	private final String ERROR_MSG = "Los campos introducidos no son validos";
	private final String EQUAL_MSG = "No has realizado ningun cambio";

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
			// server
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
		default:
			break;
		}
	}

	private void addBuilding() {

		if (checkValues()) {
			Building newBuilding = new Building(ui.getPostalCode(), ui.getName());

			if (oldBuilding != null) {
				if (!oldBuilding.equals(newBuilding)) {
					// Server
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

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_ENTER:
			addBuilding();
			break;

		default:
			break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

}
