package com.bolsadeideas.springboot.form.app.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.bolsadeideas.springboot.form.app.models.domain.Role;

@Service
public class RoleServicesImpl implements RoleService {
	
	private List<Role> roles;
	
	public RoleServicesImpl() {
		this.roles = new ArrayList<>();
		this.roles.add(new Role("Admin"));
		this.roles.add(new Role("Moderador"));
		this.roles.add(new Role("Usuario"));
	}
	
	@Override
	public List<Role> listar() {
		return roles;
	}
	
	@Override
	public Role obtenerPorNombre(String nombreRole) {
		Role resultado = null;
		for(Role role: roles) {
			if(nombreRole == role.getNombreRole()) {
				resultado = role;
				break;
			}
		}
		return resultado;
	}
}
