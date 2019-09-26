package com.cientooncemil.estacionamiento.repository;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;
import com.cientooncemil.estacionamiento.models.*;

@Repository
public class PropietarioRepository {

	private ArrayList<Propietario> propietarios;
	
	private Integer currentIndex;
	
	public PropietarioRepository() {
		this.propietarios = new ArrayList<Propietario>();
		this.currentIndex = 1;
	}
	
	public void addPropietario(Propietario propietario) {
		if(propietario.getId()==null) {
			//propietario.setId(this.getPropietariosCount() + 1);
			propietario.setId(this.currentIndex);
			this.currentIndex++;
		}
		this.propietarios.add(propietario);
	}

	public ArrayList<Propietario> getPropietarios() {
		return propietarios;
	}
	
	public Integer getPropietariosCount() {
		return this.propietarios.size();
	}

	public Propietario findPropietarioWithId(String id) {
		Propietario result = null;
		
		for (Propietario p : this.propietarios) {
			if(p.getId().toString().equals(id)) {
				result = p;
			}
		}
		
		return result;
	}


	public void removePropietarioWithId(Integer id) {
		int index = 0;
		
		for (int i=0; i<this.propietarios.size(); i++) {
			if(this.propietarios.get(i).getId().equals(id)) {
				index = i;
			}
		}
		
		this.propietarios.remove(index);		
	}
}
