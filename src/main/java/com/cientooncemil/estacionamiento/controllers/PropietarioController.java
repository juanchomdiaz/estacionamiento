package com.cientooncemil.estacionamiento.controllers;

import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.RedirectView;

import com.cientooncemil.estacionamiento.models.Propietario;
import com.cientooncemil.estacionamiento.models.json.PropietarioJsonResponse;
import com.cientooncemil.estacionamiento.repository.PropietarioRepository;

@Controller
@RequestMapping("propietarios")
public class PropietarioController {
	
	@Autowired
	private PropietarioRepository propietarioRepository;
	
	@GetMapping("listar")
	public String listarPropietarios(Model model) {
		model.addAttribute("propietario", new Propietario());
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
		if(propietario.getId()!=null) {
			this.propietarioRepository.removePropietarioWithId(propietario.getId());
		}
		
		this.propietarioRepository.addPropietario(propietario);
		
		model.addAttribute("mensaje", "El propietario se guardó exitosamente...");
		return new RedirectView("listar");	
	}
	
	@PostMapping(value = "/guardarAjax", produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public PropietarioJsonResponse guardarPropietario(@ModelAttribute @Valid Propietario propietario,
	         BindingResult result) {

		  PropietarioJsonResponse response = new PropietarioJsonResponse();
	      
	      if(result.hasErrors()){
	         
	         //Get error message
	         Map<String, String> errors = result.getFieldErrors().stream()
	               .collect(
	                     Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage)
	                 );
	         
	         response.setValidated(false);
	         response.setErrorMessages(errors);
	      }else{
	  		 response.setFirstCreated(this.propietarioRepository.getPropietariosCount()==0);
	  		 
	  		 this.propietarioRepository.addPropietario(propietario);

	         response.setValidated(true);
	         response.setPropietario(propietario);
	      }
	      return response;
	}
	
	@GetMapping("editar")
	public String editarPropietario(@RequestParam String id, Model model) {
		Propietario propietario = this.propietarioRepository.findPropietarioWithId(id);
		model.addAttribute("propietario", propietario);
		return "propietarios/nuevoForm";
	}
	
	@GetMapping("eliminar")
	public RedirectView eliminarPropietario(@RequestParam String id) {
		this.propietarioRepository.removePropietarioWithId(Integer.valueOf(id));
		return new RedirectView("listar");	
	}
}
