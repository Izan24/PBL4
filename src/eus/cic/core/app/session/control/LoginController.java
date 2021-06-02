package eus.cic.core.app.session.control;

import org.json.JSONObject;

import eus.cic.core.app.connection.APIutils;
import eus.cic.core.app.interfaces.IRoundButtonListener;
import eus.cic.core.app.session.SessionHandler;
import eus.cic.core.app.session.ui.LoginUI;
import eus.cic.core.app.ui.dialogs.CreationErrorDialog;

public class LoginController implements IRoundButtonListener{
	
	
	public static final String ERROR_STRING = "Error en la verificacion de datos.";
	public static final String INVALID_STRING = "Credenciales no válidas.";
	
	public LoginUI vista;
	public Boolean logged;
	
	public LoginController() {
		logged = false;
		vista = new LoginUI(this);
		vista.setVisible(true);
	}
	
	public static void getLogin() {
		LoginController con = new LoginController();
		while(!con.isLogged());
		System.out.println("Uwu");
	}
	
	public static void main(String[] args) {
		getLogin();
	}
	
	@Override
	public void actionPerformed(String actionCommand) {
		if (actionCommand.equals("submit")) {
			String user = vista.getUser();
			String pass = vista.getPassword();
			JSONObject json = sendLoginRequest(user, pass);
			if (!(json == null)) {
				SessionHandler.setSession(json.getString("sessin"), json.getInt("user_id"));
				vista.dispose();
				logged = true;
			}
		}
		
	}

	private JSONObject sendLoginRequest(String user, String pass) {
		JSONObject form = new JSONObject();
		form.put("user", user).put("pass", pass);
		
		JSONObject response = APIutils.postRequest("/api/login", form);
		
		if (!response.getString("status").equals("success")) {
			new CreationErrorDialog(vista, "Error: conexion", true, ERROR_STRING);
			return null;
		} else {
			if (response.getString("login").equals("correct")) {
				return response;
			}
			else {
				new CreationErrorDialog(vista, "Error: "+response.getString("login"), true, INVALID_STRING);
				return null;
			}
		}		

	}
	
	public Boolean isLogged() {
		return logged;
	}

}
