package eus.cic.core.app.admin.controller.room;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import eus.cic.core.app.admin.ui.room.AdminRoomUI;
import eus.cic.core.app.interfaces.IClickable;
import eus.cic.core.app.interfaces.IRoundButtonListener;
import eus.cic.core.app.main.PrincipalWindow;
import eus.cic.core.models.Room;

public class AdminRoomController implements IRoundButtonListener, IClickable, KeyListener {

	Room oldRoom;
	AdminRoomUI ui;
	PrincipalWindow window;

	public AdminRoomController(AdminRoomUI ui, PrincipalWindow window) {
		this.ui = ui;
		this.window = window;
		oldRoom = null;
	}

	@Override
	public void actionPerformed(String actionCommand) {
		System.err.println("a");
		switch (actionCommand) {
		case AdminRoomControllerAC.ADD_ROOM:
			addRoom();
			break;
		case AdminRoomControllerAC.REMOVE_ROOM:
			ui.removeRoom();
			break;
		case AdminRoomControllerAC.EDIT_ROOM:
			oldRoom = ui.getSelectedValue();
			try {
				ui.setDescriptionField(oldRoom.getDescription());
				ui.setFloorField(oldRoom.getFloor());
				ui.setBuilding(oldRoom.getBuilding());
			} catch (NullPointerException e) {
			}
			break;

		default:
			break;
		}

	}

	private void addRoom() {
		System.out.println("ADD " + ui.getFloor() + " " + ui.getDescription());

	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_ENTER:
			// addBuilding();
			break;

		default:
			break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	@Override
	public void clicked() {
		// doble
	}
}
