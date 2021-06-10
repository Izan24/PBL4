package eus.cic.core.app.user.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.UIManager;

import eus.cic.core.app.admin.ui.building.AdminBuildingUI;
import eus.cic.core.app.main.PrincipalWindow;
import eus.cic.core.app.uicomponents.dialogs.CreationErrorDialog;
import eus.cic.core.app.user.ui.UserUI;
import eus.cic.core.app.user.ui.profile.UserProfileUI;
import eus.cic.core.models.User;

public class UserUIController implements ActionListener {
	
	PrincipalWindow window;
	User user;
	public UserUI ui;
	UserProfileUI userProfileUI;

	private static final String ERROR_MSG = "Esta funcionalidad no se ha implementado todavia";
	
	public UserUIController(UserUI ui, User user, PrincipalWindow window) {
		this.ui = ui;
		this.user = user;
		this.window = window;
		
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
			new CreationErrorDialog(window, "Alerta: no implementado", true, ERROR_MSG);
			break;
		case UserUIControllerAC.BONDS:
			new CreationErrorDialog(window, "Alerta: no implementado", true, ERROR_MSG);
			break;
		case UserUIControllerAC.RESERVES:
			new CreationErrorDialog(window, "Alerta: no implementado", true, ERROR_MSG);
			break;
		case UserUIControllerAC.MEETINGS:
			new CreationErrorDialog(window, "Alerta: no implementado", true, ERROR_MSG);
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
