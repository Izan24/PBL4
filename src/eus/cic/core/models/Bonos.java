package eus.cic.core.models;

public class Bonos {

	Integer date;
	Integer horas;

	public Bonos(Integer date, Integer horas) {
		this.date = date;
		this.horas = horas;
	}

	public Integer getDate() {
		return date;
	}

	public void setDate(Integer date) {
		this.date = date;
	}

	public Integer getHoras() {
		return horas;
	}

	public void setHoras(Integer horas) {
		this.horas = horas;
	}
}
