package com.bolsadeideas.springboot.form.app.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.bolsadeideas.springboot.form.app.models.domain.Role;
import com.bolsadeideas.springboot.form.app.models.domain.Usuario;
import com.bolsadeideas.springboot.form.app.services.RoleService;
import com.bolsadeideas.springboot.form.app.validation.UsuarioValidador;

import jakarta.validation.Valid;

@Controller
@SessionAttributes("usuario")
public class FormController {
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private UsuarioValidador validador;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.addValidators(validador);
	}
	
	@ModelAttribute("listaRoles")
	public List<Role> listaRoles(){
		return this.roleService.listar();
	}
	
	@ModelAttribute("genero")
	public List<String> genero(){
		return Arrays.asList("M", "H", "Otro");
	}
	

	@GetMapping("/form")
	public String form(Model model) {
		
		Usuario usuario = new Usuario();
		usuario.setRoles(Arrays.asList(new Role("Usuario")));
		
		model.addAttribute("titulo", "Formulario usuarios");
		model.addAttribute("usuario", usuario);
		
		return "form";
	}
	
	@PostMapping("/form")
	public String procesarFormulario(@Valid Usuario usuario, BindingResult result, Model model) {
		
		if(result.hasErrors()) {
			model.addAttribute("titulo", "Formulario usuarios");
			return "form";
		}
		
		return "redirect:/ver";
	}
	
	@GetMapping("/ver")
	public String ver(@SessionAttribute(name="usuario", required = false) Usuario usuario, Model model, SessionStatus status) {
		if(usuario == null) {
			return "redirect:/form";
		}
		
		model.addAttribute("titulo", "Hola, "+ usuario.getUsername() +", estas son tus credenciales" );
		
		status.setComplete();
		
		return "resultado";
	}
}
