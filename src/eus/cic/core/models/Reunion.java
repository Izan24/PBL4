package eus.cic.core.models;

import java.util.List;

public class Reunion {
	Integer reunionId;
	Integer organizadorId;
	Integer salaId;
	List<Trabajador> asistentes;

	public Reunion(Integer reunionId, Integer organizadorId, Integer salaId, List<Trabajador> asistentes) {
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

	public List<Trabajador> getAsistentes() {
		return asistentes;
	}

	public void setAsistentes(List<Trabajador> asistentes) {
		this.asistentes = asistentes;
	}

	public void addAsistant(Trabajador asistente) {
		asistentes.add(asistente);
	}
}
