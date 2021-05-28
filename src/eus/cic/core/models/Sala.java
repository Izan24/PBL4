package eus.cic.core.models;

public class Sala {
	
	String edificioId;
	String piso;
	String descripcion;
	Boolean habilitado;
	
	public Sala(String descripcion, String edificioId, String piso, Boolean habilitado) {
		this.descripcion = descripcion;
		this.edificioId = edificioId;
		this.piso = piso;
		this.habilitado = habilitado;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public String getEdificioId() {
		return edificioId;
	}

	public String getPiso() {
		return piso;
	}

	public Boolean getHabilitado() {
		return habilitado;
	}
	
	public void setHabilitado(Boolean habilitado) {
		this.habilitado = habilitado;
	}
}