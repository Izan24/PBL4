package eus.cic.core.models;

import java.util.List;

public class Meeting {
	Integer meetingId;
	Integer organizerId;
	Integer roomId;
	List<User> attendants;

	public Meeting(Integer meetingId, Integer organizerId, Integer roomId, List<User> attendants) {
		this.meetingId = meetingId;
		this.organizerId = organizerId;
		this.roomId = roomId;
		this.attendants = attendants;
	}

	public Integer getReunionId() {
		return meetingId;
	}

	public Integer getOrganizerId() {
		return organizerId;
	}

	public Integer getRoomId() {
		return roomId;
	}

	public List<User> getAsistentes() {
		return attendants;
	}

	public void setAsistentes(List<User> attendants) {
		this.attendants = attendants;
	}

	public void addAsistant(User attendant) {
		attendants.add(attendant);
	}
}
