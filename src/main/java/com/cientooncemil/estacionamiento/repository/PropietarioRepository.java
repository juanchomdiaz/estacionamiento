package com.cientooncemil.estacionamiento.repository;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;
import com.cientooncemil.estacionamiento.models.*;

@Repository
public class PropietarioRepository {

	private ArrayList<Propietario> propietarios;
	
	public PropietarioRepository() {
		this.propietarios = new ArrayList<Propietario>();
	}
	
	public void addPropietario(Propietario propietario) {
		this.propietarios.add(propietario);
	}

	public ArrayList<Propietario> getPropietarios() {
		return propietarios;
	}
	
	public Integer getPropietariosCount() {
		return this.propietarios.size();
	}
}
