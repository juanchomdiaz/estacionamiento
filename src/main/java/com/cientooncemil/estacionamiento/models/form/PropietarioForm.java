package com.cientooncemil.estacionamiento.models.form;

import com.cientooncemil.estacionamiento.models.MarcaVehiculo;
import com.cientooncemil.estacionamiento.models.ModeloVehiculo;
import com.cientooncemil.estacionamiento.models.Propietario;

public class PropietarioForm {
	
	private Propietario propietario;
	private String tipoVehiculo;
	private String matriculaVehiculo;
	private MarcaVehiculo marca;
	private ModeloVehiculo modelo;
	
	public Propietario getPropietario() {
		return propietario;
	}
	
	public void setPropietario(Propietario propietario) {
		this.propietario = propietario;
	}
	
	public String getTipoVehiculo() {
		return tipoVehiculo;
	}
	
	public void setTipoVehiculo(String tipoVehiculo) {
		this.tipoVehiculo = tipoVehiculo;
	}
	
	public String getMatriculaVehiculo() {
		return matriculaVehiculo;
	}
	
	public void setMatriculaVehiculo(String matriculaVehiculo) {
		this.matriculaVehiculo = matriculaVehiculo;
	}
	
	public MarcaVehiculo getMarca() {
		return marca;
	}
	
	public void setMarca(MarcaVehiculo marca) {
		this.marca = marca;
	}
	
	public ModeloVehiculo getModelo() {
		return modelo;
	}
	
	public void setModelo(ModeloVehiculo modelo) {
		this.modelo = modelo;
	}
}
