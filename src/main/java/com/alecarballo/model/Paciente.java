package com.alecarballo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

@Entity
public class Paciente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idPaciente;
	
	@Size(min = 3, message ="Nombres deben tener minimo 3 caracteres")
	@Column(name = "nombres", nullable= false, length=70)
	private String nombres;
	
	@Size(min = 3, message ="Apellidos deben tener minimo 3 caracteres")
	@Column(name = "apellidos", nullable= false, length=70)
	private String apellido;
	
	@Size(min = 3, max = 8, message ="DNI deben tener minimo 8 caracteres")
	@Column(name = "dni", nullable= false, length=8)
	private String dni;
	
	@Size(min = 3, max = 150, message ="Dirección deben tener minimo 3 caracteres")
	@Column(name = "direccion", nullable= false, length=150)
	private String direccion;
	
	@Size(min = 9, max = 9, message ="Telefono deben tener minimo 9 caracteres")
	@Column(name = "telefono", nullable= false, length = 9)
	private String telefono;
	
	@Email
	@Column(name = "email", nullable= true, length = 55)
	private String email;

	public Integer getIdPaciente() {
		return idPaciente;
	}

	public void setIdPaciente(Integer idPaciente) {
		this.idPaciente = idPaciente;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	

}
