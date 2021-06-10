package eus.cic.core.app.user.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.UIManager;

import eus.cic.core.app.admin.ui.building.AdminBuildingUI;
import eus.cic.core.app.user.ui.UserUI;
import eus.cic.core.app.user.ui.profile.UserProfileUI;
import eus.cic.core.models.User;

public class UserUIController implements ActionListener {

	User user;

	public UserUI ui;

	UserProfileUI userProfileUI;

	public UserUIController(UserUI ui, User user) {
		this.ui = ui;
		this.user = user;

		setUISToNull();

		setStartUI();
	}

	private void setStartUI() {
		userProfileUI = new UserProfileUI(user);
		ui.setStartUI(userProfileUI);
	}

	private void setUISToNull() {
		userProfileUI = null;
	}

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
			if (userProfileUI == null) {
				userProfileUI = new UserProfileUI(user);
			}
			ui.setCenterPanel(userProfileUI);

			break;
		default:
			break;
		}
	}

}
