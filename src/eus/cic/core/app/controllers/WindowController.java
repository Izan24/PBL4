package eus.cic.core.app.controllers;

import eus.cic.core.app.ui.PrincipalWindow;
import eus.cic.core.app.ui.panels.AdminUI;
import eus.cic.core.app.ui.panels.UserUI;
import eus.cic.core.models.User;

public class WindowController {

	PrincipalWindow window;
	AdminUI adminUI;
	UserUI userUI;
	User trabajador;

	public WindowController(PrincipalWindow window, User trabajador) {
		this.trabajador = trabajador;
		
		initUIS();
		setStartView();
	}

	private void initUIS() {
		//Iniciar las UI usando el consructor que tenga cada uno.
	}
	
	private void setStartView() {
		//Switch que comprueba que el usuario 
	}
}
