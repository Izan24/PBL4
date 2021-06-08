package eus.cic.core.app.admin.controller.rooms;

import eus.cic.core.app.interfaces.IRoundButtonListener;

public class AdminRoomController implements IRoundButtonListener {

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

}
