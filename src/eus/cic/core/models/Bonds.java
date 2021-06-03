package eus.cic.core.models;

public class Bonds {

	Integer date;
	Integer hours;

	public Bonds(Integer date, Integer hours) {
		this.date = date;
		this.hours = hours;
	}

	public Integer getDate() {
		return date;
	}

	public void setDate(Integer date) {
		this.date = date;
	}

	public Integer getHours() {
		return hours;
	}

	public void setHours(Integer hours) {
		this.hours = hours;
	}
}
