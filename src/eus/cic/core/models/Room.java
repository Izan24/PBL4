package eus.cic.core.models;

public class Room {
	
	Building buildingId;
	String floor;
	String description;
	Boolean enabled;
	
	public Room(String description, Building buildingId, String floor, Boolean enabled) {
		this.description = description;
		this.buildingId = buildingId;
		this.floor = floor;
		this.enabled = enabled;
	}

	public String getDescription() {
		return description;
	}

	public Building getBuilding() {
		return buildingId;
	}

	public String getFloor() {
		return floor;
	}

	public Boolean isEnabled() {
		return enabled;
	}
	
	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}
}