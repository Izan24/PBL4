package eus.cic.core.models;

public class Building {
	Integer buildingId;
	String postalCode;
	String name;

	public Building(Integer buildingId, String postalCode, String name) {
		this.buildingId = buildingId;
		this.postalCode = postalCode;
		this.name = name;
	}

	public Integer getBuildingId() {
		return buildingId;
	}


	public String getPostalCode() {
		return postalCode;
	}

	public String getNombre() {
		return name;
	}

}
