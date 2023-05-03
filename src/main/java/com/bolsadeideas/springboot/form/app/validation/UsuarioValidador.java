package com.bolsadeideas.springboot.form.app.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.bolsadeideas.springboot.form.app.models.domain.Usuario;

@Component
public class UsuarioValidador implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Usuario.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Usuario usuario = (Usuario)target;
		
		if(!usuario.getUsername().matches("[a-zA-Z0-9]{3,9}")) {
			errors.rejectValue("username", "Pattern.usuario.username");
		}
		

	}

}

