package eus.cic.core.models;

public class Project {

	Integer estimatedHours;

	public Project(Integer estimatedHours) {
		this.estimatedHours = estimatedHours;
	}

	public Integer getEstimatedHours() {
		return estimatedHours;
	}

	public void setEstimatedHours(Integer estimatedHours) {
		this.estimatedHours = estimatedHours;
	}
}
