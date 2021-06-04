package eus.cic.core.app.admin.controller.building;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import eus.cic.core.app.admin.ui.building.AdminBuilding;
import eus.cic.core.app.interfaces.IClickable;

public class AdminBuildingController implements ActionListener, IClickable {

	AdminBuilding ui;

	public AdminBuildingController(AdminBuilding ui) {
		this.ui = ui;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case AdminBuildingControllerAC.ADD_BUILDING:
			System.out.println("Add_Building");
			break;
		case AdminBuildingControllerAC.REMOVE_BUILDING:
			System.out.println("RemoveBuilding");
			break;
		case AdminBuildingControllerAC.EDIT_BUILDING:
			/* TODO crea una variable local en la que pilles el selected item, cuando le des a add building, si la variable != null 
			*  haces un get del list y editas ese valor, en caso de que sea null haces un add al list
			*/
			System.out.println("Edit building");
			break;
		}
	}

	@Override
	public void clicked() {
		/* TODO crea una variable local en la que pilles el selected item, cuando le des a add building, si la variable != null 
		*  haces un get del list y editas ese valor, en caso de que sea null haces un add al list
		*/
		System.out.println("Dobbblee");
	}

}
