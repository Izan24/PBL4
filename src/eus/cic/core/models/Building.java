package eus.cic.core.models;

public class Building {
	Integer edificioId;
	String codigoPostal;
	String nombre;

	public Building(Integer edificioId, String codigoPostal, String nombre) {
		this.edificioId = edificioId;
		this.codigoPostal = codigoPostal;
		this.nombre = nombre;
	}

	public Integer getEdificioId() {
		return edificioId;
	}

	public String getCodigoPostal() {
		return codigoPostal;
	}

	public String getNombre() {
		return nombre;
	}

}
