package eus.cic.core.app.user.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserUIController implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {

		switch (e.getActionCommand()) {
		case UserUIControllerAC.CHECKINS:

			break;
		case UserUIControllerAC.BONDS:

			break;
		case UserUIControllerAC.RESERVES:

			break;
		case UserUIControllerAC.MEETINGS:

			break;
		case UserUIControllerAC.PROFILE:

			break;
		default:
			break;
		}
	}

}
