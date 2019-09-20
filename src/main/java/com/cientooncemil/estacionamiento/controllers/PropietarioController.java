package com.cientooncemil.estacionamiento.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import com.cientooncemil.estacionamiento.models.Propietario;
import com.cientooncemil.estacionamiento.repository.PropietarioRepository;

@Controller
@RequestMapping("propietarios")
public class PropietarioController {
	
	@Autowired
	private PropietarioRepository propietarioRepository;
	
	@GetMapping("listar")
	public String listarPropietarios(Model model) {
		model.addAttribute("propietarios",this.propietarioRepository.getPropietarios());
		return "propietarios/todos";
	}
	
	@GetMapping("nuevo")
	public String nuevoPropietario(Model model) {
		model.addAttribute("propietario", new Propietario());
		return "propietarios/nuevoForm";
	}

	@PostMapping("guardar")
	public RedirectView guardarPropietario(@ModelAttribute Propietario propietario, Model model) {
		this.propietarioRepository.addPropietario(propietario);
		
		model.addAttribute("mensaje", "El propietario se guardó exitosamente...");
		return new RedirectView("listar");	}
}
