package eus.cic.core.app.utils;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import eus.cic.core.models.Building;
import eus.cic.core.models.Room;
import eus.cic.core.models.User;

public class JSONParser {
	public static User parseUser(JSONObject json) {
		String name = json.getString("name");
		String surname = json.getString("surname");
		String postalCode = json.getString("postal_code");
		String dept = json.getString("department");
		String address = json.getString("address");
		String prefix = json.getString("prefix");
		String phone = json.getString("telephone");
		String email = json.getString("email");
		String dni = json.getString("dni");
		Boolean isAdmin = json.getBoolean("is_admin");
		List<Room> permission = parsePermissions(json.getJSONArray("perms"));
		
		return new User(name, surname, postalCode, address, prefix, phone, dept, dni, isAdmin, permission);
	}

	private static List<Room> parsePermissions(JSONArray jsonArray) {
		// TODO Auto-generated method stub
		return null;
	}

	public static List<Building> getBuildings() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
