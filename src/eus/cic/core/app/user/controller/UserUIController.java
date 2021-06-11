package eus.cic.core.app.user.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.UIManager;

import eus.cic.core.app.admin.ui.building.AdminBuildingUI;
import eus.cic.core.app.main.PrincipalWindow;
import eus.cic.core.app.session.SessionException;
import eus.cic.core.app.session.SessionHandler;
import eus.cic.core.app.uicomponents.dialogs.CreationErrorDialog;
import eus.cic.core.app.user.ui.UserUI;
import eus.cic.core.app.user.ui.profile.UserProfileUI;
import eus.cic.core.models.User;

public class UserUIController implements ActionListener {

	PrincipalWindow window;
	public UserUI ui;
	UserProfileUI userProfileUI;

	private static final String ERROR_MSG = "Esta funcionalidad no se ha implementado todavia";

	public UserUIController(UserUI ui, PrincipalWindow window) {
		this.ui = ui;

		this.window = window;

		setStartUI();
	}

	private void setStartUI() {
		try {
			userProfileUI = new UserProfileUI(SessionHandler.getUser());
		} catch (SessionException e) {
			window.disposeWindow();
		}
		ui.setStartUI(userProfileUI);
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
			try {
				userProfileUI = new UserProfileUI(SessionHandler.getUser());
			} catch (SessionException e1) {
				window.disposeWindow();
			}

			break;
		default:
			break;
		}
	}

}
