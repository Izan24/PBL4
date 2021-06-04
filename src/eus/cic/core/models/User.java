package eus.cic.core.models;

import java.util.List;

public class User {

	String name;
	String surname;
	String postalCode;
	String address;
	String prefix;
	String phoneNumber;
	String departamento;
	String dni;
	Boolean admin;
	String email;
	List<Room> permissions;

	public User(String name, String surname, String postalCode, String address, String prefix,
			String phoneNumber, String email,String departamento, String dni, Boolean admin, List<Room> permissions) {
		this.name = name;
		this.surname = surname;
		this.postalCode = postalCode;
		this.address = address;
		this.prefix = prefix;
		this.phoneNumber = phoneNumber;
		this.departamento = departamento;
		this.dni = dni;
		this.admin = admin;
		this.permissions = permissions;
	}

	public String getNombre() {
		return name;
	}

	public String getSurname() {
		return surname;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public String getAddress() {
		return address;
	}

	public String getPrefix() {
		return prefix;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getDepartamento() {
		return departamento;
	}

	public String getDni() {
		return dni;
	}

	public List<Room> getPermissions() {
		return permissions;
	}

	public void setPermissions(List<Room> permissions) {
		this.permissions = permissions;
	}

	public void addPermission(Room room) {
		permissions.add(room);
	}

	public void removePermission(Room room) {
		permissions.remove(room);
	}

	public Boolean isAdmin() {
		return admin;
	}

}
