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
		List<Room> permission = parsePermissions(json.getJSONArray("permissions"));
		
		return new User(name, surname, postalCode, address, prefix, phone,email, dept, dni, isAdmin, permission);
	}

	private static List<Room> parsePermissions(JSONArray jsonArray) {
		List<Room> rooms = new ArrayList<>();
		for (Object object : jsonArray) {
			JSONObject json = (JSONObject)object;
			rooms.add(parseRoom(json));
		}
		return rooms;
	}
	
	private static Room parseRoom(JSONObject json) {
		String description = json.getString("description");
		String floor = json.getString("floor");
		Building building = parseBuilding(json.getJSONObject("buildings"));
		Boolean enabled = json.getBoolean("enabled");
		Room room = new Room(description, building, floor, enabled);
		return room;
	}

	
	private static Building parseBuilding(JSONObject buildJSON) {
		String name = buildJSON.getString("name");
		String p_code = buildJSON.getString("postal_code");
		Integer id = buildJSON.getInt("id");
		Building building = new Building(id, p_code, name);
		return building;
	}
	
	public static List<Building> parseBuildings(JSONArray array) {
		List<Building> buildings = new ArrayList<>();
		for (Object object : array) {
			JSONObject json = (JSONObject)object;
			buildings.add(parseBuilding(json));
		}
		return buildings;
	}
	
	
}
