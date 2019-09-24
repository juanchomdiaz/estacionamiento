package com.cientooncemil.estacionamiento.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import com.cientooncemil.estacionamiento.models.Usuario;
import com.cientooncemil.estacionamiento.repository.UsuarioRepository;

@Controller
public class LoginController {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	
	@GetMapping("/")
	public String mostrarLoginForm(Model model) {
		model.addAttribute("usuario", new Usuario());
		return "login/loginForm";		
	}
	
	@PostMapping("/login")
	public RedirectView login(@ModelAttribute Usuario usuario) {
		RedirectView redirect = new RedirectView("/");
		
		Usuario u = this.usuarioRepository.obtenerUsuarioConNombreUsuario(usuario.getNombreUsuario());
		
		if(u!=null && u.getPassword().equals(usuario.getPassword()))  {
			redirect = new RedirectView("propietarios/listar");
		} 
		
		return redirect;		
	}
	
}
