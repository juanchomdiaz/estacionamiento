package com.cientooncemil.estacionamiento.models;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Propietario {
	
	@Value("Juan")
	private String nombre;
	
	@Value("Diaz")
	private String apellido;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

}
