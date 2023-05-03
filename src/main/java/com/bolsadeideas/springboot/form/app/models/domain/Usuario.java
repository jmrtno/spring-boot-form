package com.bolsadeideas.springboot.form.app.models.domain;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class Usuario {
	
	@NotEmpty
	private String username;
	@NotEmpty
	@Pattern(regexp = "[0-9]{8}[TRWAGMYFPDXBNJZSQVHLCKE]{1}") // VALIDACIÓN PERSONALIZADA
	private String DNI;
	@NotEmpty
	private String genero;
	@NotNull
	@Past
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fechaNacimiento;
	@NotEmpty
	private List<Role> roles;
	@NotEmpty
	@Email
	private String email;
	@NotEmpty
	@Size(min = 5, max = 12)
	private String pass;
	@NotNull
	@AssertTrue
	private Boolean terminos;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getDNI() {
		return DNI;
	}
	public void setDNI(String dNI) {
		DNI = dNI;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public Boolean getTerminos() {
		return terminos;
	}
	public void setTerminos(Boolean terminos) {
		this.terminos = terminos;
	}
	
	
	
	
	
}
