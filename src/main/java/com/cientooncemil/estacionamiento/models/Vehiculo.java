package com.cientooncemil.estacionamiento.models;

public class Vehiculo {
	
	public static Vehiculo getInstanceOf(String type) {
		Vehiculo result = null;
		switch (type) {
			case "auto":
				result = new Auto();
				break;
			case "camioneta":
				result = new Camioneta();
				break;		
		    case "moto":
				result = new Moto();
				break;
		}
		
		return result;
	}

}
