package eus.cic.core.app.utils;

import java.util.ArrayList;
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
		
		return new User(name, surname, postalCode, address, prefix, phone,email, dept, dni, isAdmin, permission);
	}

	private static List<Room> parsePermissions(JSONArray jsonArray) {
		List<Room> rooms = new ArrayList<>();
		for (Object object : jsonArray) {
			JSONObject json = (JSONObject)object;
			String description = json.getString("description");
			String floor = json.getString("floor");
			String building = json.getString("building");
			Boolean enabled = json.getBoolean("enabled");
			Room room = new Room(description, building, floor, enabled);
			rooms.add(room);
		}
		return rooms;
	}

	
	public static List<Building> parseBuildings(JSONArray jsonArray){
		List<Building> buildings = new ArrayList<>();
		for (Object object : jsonArray) {
			JSONObject json = (JSONObject)object;
			Integer buildingId = json.getInt("building_id");
			String postalCode = json.getString("postal_code");
			String name = json.getString("name");
			Building building = new Building(buildingId, postalCode, name);
			buildings.add(building);
		}
		return buildings;
	}
	
	
}
