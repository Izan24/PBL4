package eus.cic.core.app.session.control;

import org.json.JSONObject;

import eus.cic.core.app.connection.APIutils;
import eus.cic.core.app.interfaces.IRoundButtonListener;
import eus.cic.core.app.session.ui.LoginUI;
import eus.cic.core.app.ui.dialogs.CreationErrorDialog;

public class LoginController implements IRoundButtonListener{
	
	
	public static final String ERROR_STRING = "Error en la verificacion de datos.";
	public static final String INVALID_STRING = "Credenciales no válidas.";
	
	public LoginUI vista;
	
	public LoginController() {
		vista = new LoginUI(this);
		vista.setVisible(true);
	}
	
	public static void main(String[] args) {
		LoginController con = new LoginController();
	}
	
	@Override
	public void actionPerformed(String actionCommand) {
		if (actionCommand.equals("submit")) {
			String user = vista.getUser();
			String pass = vista.getPassword();
			Boolean loginSuccessBoolean = sendLoginRequest(user, pass);
			if (loginSuccessBoolean) {
				System.out.println("Uwu");
			}
		}
		
	}

	private Boolean sendLoginRequest(String user, String pass) {
		JSONObject form = new JSONObject();
		form.put("user", user).put("pass", pass);
		
		JSONObject response = APIutils.postRequest("/api/login", form);
		
		if (!response.getString("status").equals("success")) {
			new CreationErrorDialog(vista, "Error: "+response.getString("error"), true, ERROR_STRING);
		} else {
			if (response.getString("login").equals("correct")) {
				return true;
			}
			else {
				new CreationErrorDialog(vista, "Error: "+response.getString("login"), true, INVALID_STRING);
			}
		}		
		return false;
	}

}
