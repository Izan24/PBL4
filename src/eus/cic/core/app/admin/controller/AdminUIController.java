package eus.cic.core.app.admin.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import eus.cic.core.app.admin.ui.AdminUI;
import eus.cic.core.app.admin.ui.building.AdminBuildingUI;
import eus.cic.core.app.interfaces.IRoundButtonListener;

public class AdminUIController implements ActionListener, IRoundButtonListener{
	
	AdminUI ui;
	
	AdminBuildingUI buildingUI;
	
	public AdminUIController(AdminUI ui) {
		this.ui = ui;
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		switch (e.getActionCommand()) {
		case AdminUIControllerAC.BUILDINGS:
			if (buildingUI == null) {
				buildingUI = new AdminBuildingUI();
			}
			ui.enableHome();
			
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
		case AdminUIControllerAC.MENU:
			ui.disableHome();
			//ui.setCenterPanel(centerPanel); //Poner panel menu;
			
			break;

		}
	}

	@Override
	public void actionPerformed(String actionCommand) {
		if (actionCommand.equals(AdminUIControllerAC.MENU));
		
	}

}
