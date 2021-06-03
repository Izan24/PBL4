package eus.cic.core.models;

import java.util.List;

public class User {

	String name;
	String apellido;
	String codigoPostal;
	String direccion;
	String prefijo;
	String telefono;
	String departamento;
	String dni;
	Boolean admin;
	List<Room> permisos;

	public User(String name, String apellido, String codigoPostal, String direccion, String prefijo,
			String telefono, String departamento, String dni, Boolean admin, List<Room> permisos) {
		this.name = name;
		this.apellido = apellido;
		this.codigoPostal = codigoPostal;
		this.direccion = direccion;
		this.prefijo = prefijo;
		this.telefono = telefono;
		this.departamento = departamento;
		this.dni = dni;
		this.admin = admin;
		this.permisos = permisos;
	}

	public String getNombre() {
		return name;
	}

	public String getApellido() {
		return apellido;
	}

	public String getCodigoPostal() {
		return codigoPostal;
	}

	public String getDireccion() {
		return direccion;
	}

	public String getPrefijo() {
		return prefijo;
	}

	public String getTelefono() {
		return telefono;
	}

	public String getDepartamento() {
		return departamento;
	}

	public String getUsuario() {
		return usuario;
	}

	public String getDni() {
		return dni;
	}

	public List<Room> getPermisos() {
		return permisos;
	}

	public void setPermisos(List<Room> permisos) {
		this.permisos = permisos;
	}

	public void addPermiso(Room sala) {
		permisos.add(sala);
	}

	public void removePermiso(Room sala) {
		permisos.remove(sala);
	}

	public Boolean isAdmin() {
		return admin;
	}

}
