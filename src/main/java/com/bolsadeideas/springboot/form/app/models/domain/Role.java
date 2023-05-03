package com.bolsadeideas.springboot.form.app.models.domain;

public class Role {

	private String nombreRole;

	public Role() {
		
	}
	
	public Role(String nombreRole) {
		this.nombreRole = nombreRole;
	}

	public String getNombreRole() {
		return nombreRole;
	}

	public void setNombreRole(String nombreRole) {
		this.nombreRole = nombreRole;
	}
	
	@Override
	public boolean equals(Object obj) {
		
		if(this == obj) {
			return true;
		}
		
		if(!(obj instanceof Role)) {
			return false;
		}
		Role role = (Role)obj;
		return this.nombreRole != null && this.nombreRole.equals(role.getNombreRole());
	}
}
