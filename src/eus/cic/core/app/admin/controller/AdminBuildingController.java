package eus.cic.core.app.admin.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import eus.cic.core.app.interfaces.IClickable;

public class AdminBuildingController implements ActionListener, IClickable{

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case AdminBuildingControllerAC.ADD_BUILDING:
			
			break;
		case AdminBuildingControllerAC.REMOVE_BUILDING:
			
			break;
		case AdminBuildingControllerAC.EDIT_BUILDING:
			
			break;
		}
	}

	@Override
	public void clicked() {
		System.out.println("Dobbblee");
	}

}
