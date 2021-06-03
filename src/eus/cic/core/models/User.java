package eus.cic.core.models;

import java.util.List;

public class User {

	String nombre;
	String apellido;
	String codigoPostal;
	String direccion;
	String prefijo;
	String telefono;
	String departamento;
	String usuario;
	String dni;
	List<Room> permisos;

	public User(String nombre, String apellido, String codigoPostal, String direccion, String prefijo,
			String telefono, String departamento, String usuario, String dni, List<Room> permisos) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.codigoPostal = codigoPostal;
		this.direccion = direccion;
		this.prefijo = prefijo;
		this.telefono = telefono;
		this.departamento = departamento;
		this.usuario = usuario;
		this.dni = dni;
		this.permisos = permisos;
	}

	public String getNombre() {
		return nombre;
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

}
