package eus.cic.core.models;

import java.util.List;

public class Meeting {
	Integer reunionId;
	Integer organizadorId;
	Integer salaId;
	List<User> asistentes;

	public Meeting(Integer reunionId, Integer organizadorId, Integer salaId, List<User> asistentes) {
		this.reunionId = reunionId;
		this.organizadorId = organizadorId;
		this.salaId = salaId;
		this.asistentes = asistentes;
	}

	public Integer getReunionId() {
		return reunionId;
	}

	public Integer getOrganizadorId() {
		return organizadorId;
	}

	public Integer getSalaId() {
		return salaId;
	}

	public List<User> getAsistentes() {
		return asistentes;
	}

	public void setAsistentes(List<User> asistentes) {
		this.asistentes = asistentes;
	}

	public void addAsistant(User asistente) {
		asistentes.add(asistente);
	}
}
