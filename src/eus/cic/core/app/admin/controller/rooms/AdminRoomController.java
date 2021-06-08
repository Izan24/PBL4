package eus.cic.core.app.admin.controller.rooms;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import eus.cic.core.app.admin.ui.salas.AdminRoomUI;
import eus.cic.core.app.interfaces.IClickable;
import eus.cic.core.app.interfaces.IRoundButtonListener;
import eus.cic.core.app.main.PrincipalWindow;

public class AdminRoomController implements IRoundButtonListener, IClickable, KeyListener {

	AdminRoomUI ui;
	PrincipalWindow window;

	public AdminRoomController(AdminRoomUI ui, PrincipalWindow window) {
	}

	@Override
	public void actionPerformed(String actionCommand) {

		switch (actionCommand) {
		case AdminRoomControllerAC.ADD_ROOM:

			break;
		case AdminRoomControllerAC.REMOVE_ROOM:

			break;
		case AdminRoomControllerAC.EDIT_ROOM:

			break;

		default:
			break;
		}

	}

	@Override
	public void clicked() {
		// doble
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_ENTER:
			//addBuilding();
			break;

		default:
			break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

}
