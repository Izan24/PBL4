package eus.cic.core.app.utils;

import java.util.List;

import org.json.JSONObject;

import eus.cic.core.app.connection.APIutils;
import eus.cic.core.app.session.SessionException;
import eus.cic.core.app.session.SessionHandler;
import eus.cic.core.models.Building;
import eus.cic.core.models.User;

public class APIRequests {

	public static List<Building> getBuildings() throws SessionException{
		List<Building> buildings = null;
		JSONObject response = APIutils.getRequest("/api/getBuildings?session=" + SessionHandler.getSession());
		if (response.getString("status").equals("ok")) {
			buildings = JSONParser.parseBuildings(response.getJSONArray("buildings"));
		}else {
			throw new SessionException();
		}
		return buildings;
	}
	
	public static Integer insertBuilding(Building building) throws SessionException {
		Integer id = -1;
		JSONObject json = new JSONObject().put("name", building.getNombre()).put("postal_code", building.getPostalCode());
		json.put("disable", false).put("session", json.put("session", SessionHandler.getSession()));
		JSONObject response = APIutils.postRequest("/api/insertBuilding", json);
		if (response.getString("status").equals("ok")) {
			id = response.getInt("id");
		}else {
			throw new SessionException();
		}
		return id;
	}
	
	public static Integer disableBuilding(Building building) throws SessionException {
		Integer id = -1;
		JSONObject json = new JSONObject().put("name", building.getNombre()).put("postal_code", building.getPostalCode());
		JSONObject response = APIutils.postRequest("/api/insertBuilding", json.put("session", SessionHandler.getSession()));
		json.put("disable", true).put("session", json.put("session", SessionHandler.getSession()));
		if (response.getString("status").equals("ok")) {
		}else {
			throw new SessionException();
		}
		return id;
	}
	
	

	public static User getUser(Integer user_id) throws SessionException {
		User user = null;
		JSONObject response = APIutils
				.getRequest("/api/getUser?id=" + user_id + "&session=" + SessionHandler.getSession());
		if (response.getString("status").equals("ok")) {
			user = JSONParser.parseUser((response.getJSONObject("user")));
		}else {
			throw new SessionException();
		}
		return user;
	}

}
