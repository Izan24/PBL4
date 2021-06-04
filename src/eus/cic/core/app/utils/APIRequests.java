package eus.cic.core.app.utils;

import java.util.List;

import org.json.JSONObject;

import eus.cic.core.app.connection.APIutils;
import eus.cic.core.app.session.SessionHandler;
import eus.cic.core.models.Building;
import eus.cic.core.models.User;

public class APIRequests {
	
	public static List<Building> getBuildings() {
		List<Building> buildings = null;
		JSONObject response = APIutils.getRequest("/api/getBuildings?session="+SessionHandler.getSession());
		if (response.getString("status").equals("ok")) {
			buildings = JSONParser.parseBuildings(response.getJSONArray("buildings"));
		} 
		return buildings;
	}
	
	public static User getUser(Integer user_id) {
		User user = null;
		JSONObject response = APIutils.getRequest("/api/getUser?id="+user_id+"&session="+SessionHandler.getSession());
		if (response.getString("status").equals("ok")) {
			user = JSONParser.parseUser((response.getJSONObject("user")));
		}
		return user;
	}
	
}
