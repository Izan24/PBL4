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

	public Building(String postalCode, String name) {
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

	@Override
	public int hashCode() {
		return postalCode.hashCode() + name.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		boolean equal = false;
		Building b = (Building) obj;

		if (b.getNombre().equals(this.getNombre()) && b.getPostalCode().equals(this.getPostalCode()))
			equal = true;
		return equal;
	}

}
