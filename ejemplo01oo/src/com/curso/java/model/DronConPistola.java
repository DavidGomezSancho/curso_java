package com.curso.java.model;

public class DronConPistola extends Maquina implements PuedeDisparar{

	@Override
	void cargarse() {
		System.out.println("Cargando con cargadoor...");

	}

	@Override
	public void dispararSinJuicio(String objetivo) {
		System.out.println("Disparando con el dron a" + objetivo);
		
	}

}
