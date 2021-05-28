package eus.cic.core.models;

import java.util.List;

public class Trabajador {

	String nombre;
	String apellido;
	String codigoPostal;
	String direccion;
	String prefijo;
	String telefono;
	String departamento;
	String usuario;
	String dni;
	List<Sala> permisos;

	public Trabajador(String nombre, String apellido, String codigoPostal, String direccion, String prefijo,
			String telefono, String departamento, String usuario, String dni, List<Sala> permisos) {
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

	public List<Sala> getPermisos() {
		return permisos;
	}

	public void setPermisos(List<Sala> permisos) {
		this.permisos = permisos;
	}

	public void addPermiso(Sala sala) {
		permisos.add(sala);
	}

	public void removePermiso(Sala sala) {
		permisos.remove(sala);
	}

}
