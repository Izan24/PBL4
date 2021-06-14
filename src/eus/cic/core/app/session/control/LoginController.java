package eus.cic.core.app.session.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.Timer;

import org.json.JSONObject;

import eus.cic.core.app.connection.APIutils;
import eus.cic.core.app.interfaces.IRoundButtonListener;
import eus.cic.core.app.session.SessionHandler;
import eus.cic.core.app.session.ui.LoginUI;
import eus.cic.core.app.uicomponents.dialogs.CreationErrorDialog;

public class LoginController implements IRoundButtonListener, ActionListener, KeyListener {

	public static final String ERROR_STRING = "Error en la verificacion de datos.";
	public static final String INVALID_STRING = "Credenciales no válidas.";
	public static final String BLOCKED = "Has introducido las credenciales mal 5 veces. Espera 5 minutos antes de volver a intentarlo";

	private Integer badCount = 0;
	private Timer timer;
	private Boolean locked;
	private LoginUI vista;
	private Boolean logged;

	public LoginController() {
		logged = false;
		locked = false;
		vista = new LoginUI(this);
		vista.setVisible(true);
	}

	public static void getLogin() {
		LoginController con = new LoginController();
		while (!con.isLogged())
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	}

	private JSONObject sendLoginRequest(String user, String pass) {
		JSONObject form = new JSONObject();
		form.put("user", user).put("pass", pass);
		if (!locked) {
			JSONObject response = APIutils.postRequest("/api/login", form);
			if (!(response.getString("status").equals("ok"))) {
				new CreationErrorDialog(vista, "Error: conexion", true, ERROR_STRING);
				return null;
			} else {
				if (response.getString("login").equals("correct")) {
					return response;
				} else {
					new CreationErrorDialog(vista, "Error: " + response.getString("login"), true, INVALID_STRING);
					badCount++;
					if (badCount >= 5) {
						locked = true;
						timer = new Timer(300000, this);
						timer.start();
					}
					return null;
				}
			}
		} else {
			new CreationErrorDialog(vista, "Error: cuenta bloqueada temporalmente", true, BLOCKED);
		}

		return null;
	}
	
	private void sendReq() {
		String user = vista.getUser();
		String pass = vista.getPassword();
		JSONObject json = sendLoginRequest(user, pass);
		if (!(json == null)) {
			SessionHandler.setSession(json.getString("session"), json.getInt("user_id"));
			logged = true;
			vista.dispose();
		}
	}

	public Boolean isLogged() {
		return logged;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() instanceof Timer) {
			locked = false;
			timer.stop();
			timer = null;
			badCount = 0;
		}
	}

	@Override
	public void actionPerformed(String actionCommand) {
		if (actionCommand.equals("submit")) {
			sendReq();
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			sendReq();		
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

}
