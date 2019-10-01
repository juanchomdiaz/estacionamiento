package com.cientooncemil.estacionamiento.models;

import java.util.ArrayList;

public class Propietario {
	
	private Integer id;
	private String nombre;
	private String apellido;
	private ArrayList<Vehiculo> vehiculos;
	
	public Propietario() {
		this.vehiculos = new ArrayList<Vehiculo>();
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

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

	public ArrayList<Vehiculo> getVehiculos() {
		return vehiculos;
	}

	public Boolean agregarVehiculo(Vehiculo vehiculo) {
		
		if(this.vehiculos.size()<3) {
			this.vehiculos.add(vehiculo);
			return true;
		}
		
		return false;
	}
	
	

}
