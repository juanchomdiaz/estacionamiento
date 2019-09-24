package com.cientooncemil.estacionamiento.models.json;

import java.util.Map;

import com.cientooncemil.estacionamiento.models.Propietario;

public class PropietarioJsonResponse {
	
	private Propietario propietario;
	private boolean validated;
	private boolean isFirstCreated;
	private Map<String, String> errorMessages;
	
	public Propietario getPropietario() {
		return propietario;
	}
	
	public void setPropietario(Propietario propietario) {
		this.propietario = propietario;
	}
	
	public boolean isValidated() {
		return validated;
	}
	
	public void setValidated(boolean validated) {
		this.validated = validated;
	}
	
	public Map<String, String> getErrorMessages() {
		return errorMessages;
	}
	
	public void setErrorMessages(Map<String, String> errorMessages) {
		this.errorMessages = errorMessages;
	}

	public boolean isFirstCreated() {
		return isFirstCreated;
	}

	public void setFirstCreated(boolean isFirstCreated) {
		this.isFirstCreated = isFirstCreated;
	}
	
	
}
