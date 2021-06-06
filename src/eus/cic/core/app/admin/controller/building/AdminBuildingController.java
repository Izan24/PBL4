package eus.cic.core.app.admin.controller.building;

import eus.cic.core.app.admin.ui.building.AdminBuildingUI;
import eus.cic.core.app.interfaces.IClickable;
import eus.cic.core.app.interfaces.IRoundButtonListener;
import eus.cic.core.models.Building;

public class AdminBuildingController implements IRoundButtonListener, IClickable {

	AdminBuildingUI ui;
	Building oldBuilding;

	public AdminBuildingController(AdminBuildingUI ui) {
		this.ui = ui;
	}

	@Override
	public void actionPerformed(String actionCommand) {
		switch (actionCommand) {
		case AdminBuildingControllerAC.ADD_BUILDING:
			System.out.println("Add_Building");

			addBuilding();
			break;
		case AdminBuildingControllerAC.REMOVE_BUILDING:
			System.out.println("RemoveBuilding");
			ui.removeBuilding();
			break;
		case AdminBuildingControllerAC.EDIT_BUILDING:
			/*
			 * TODO crea una variable local en la que pilles el selected item, cuando le des
			 * a add building, si la variable != null haces un get del list y editas ese
			 * valor, en caso de que sea null haces un add al list
			 */
			Building oldBuilding = ui.getSelectedValue();
			ui.setNameField(oldBuilding.getNombre());
			ui.setPostalCodeField(oldBuilding.getPostalCode());

			System.out.println("Edit building");
			break;
		}
	}

	// TODO: Hcer una comprobacion de que no esté vacio y que no sea el texto
	// default
	private void addBuilding() {
		Building newBuilding = new Building(ui.getPostalCode(), ui.getName());

		if (oldBuilding != null) {
			ui.updateValue(oldBuilding, newBuilding);
			oldBuilding = null;
		} else {
			ui.addBuilding(newBuilding);
		}

	}

	@Override
	public void clicked() {
		/*
		 * TODO crea una variable local en la que pilles el selected item, cuando le des
		 * a add building, si la variable != null haces un get del list y editas ese
		 * valor, en caso de que sea null haces un add al list
		 */
		System.out.println("Dobbblee");
	}

}
