package eus.cic.core.app.admin.controller.building;

import eus.cic.core.app.admin.ui.building.AdminBuildingUI;
import eus.cic.core.app.interfaces.IClickable;
import eus.cic.core.app.interfaces.IRoundButtonListener;

public class AdminBuildingController implements IRoundButtonListener, IClickable {

	AdminBuildingUI ui;

	public AdminBuildingController(AdminBuildingUI ui) {
		this.ui = ui;
	}

	@Override
	public void actionPerformed(String actionCommand) {
		switch (actionCommand) {
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
