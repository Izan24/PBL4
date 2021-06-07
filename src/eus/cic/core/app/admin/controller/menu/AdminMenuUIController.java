package eus.cic.core.app.admin.controller.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import eus.cic.core.app.admin.ui.menu.AdminMenuUI;
import eus.cic.core.app.interfaces.IRoundButtonListener;

public class AdminMenuUIController implements ActionListener {

	AdminMenuUI adminMenuUI;

	public AdminMenuUIController(AdminMenuUI adminMenuUI) {
		this.adminMenuUI = adminMenuUI;

	}

	@Override
	public void actionPerformed(ActionEvent event) {

		switch (event.getActionCommand()) {
		case "Edificios":
			System.out.println(event.getActionCommand());
			break;

		case "Salas":
			System.out.println(event.getActionCommand());
			break;

		case "Trabajadores":
			System.out.println(event.getActionCommand());
			break;

		case "Reservas":
			System.out.println(event.getActionCommand());
			break;

		case "Tarjetas":
			System.out.println(event.getActionCommand());
			break;

		case "Proyectos":
			System.out.println(event.getActionCommand());
			break;

		case "Permisos":
			System.out.println(event.getActionCommand());
			break;

		case "Fichas":
			System.out.println(event.getActionCommand());
			break;

		case "Bonos":
			System.out.println(event.getActionCommand());
			break;

		default:
			break;
		}

	}

}
