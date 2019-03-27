package com.curso.java.modelo;

public class Profesor extends Persona implements PuedeCorregir, PuedeExplicar{
	
	
	
	@Override
	public void corregirExamen(Alumno alumno) {
		System.out.println("Examen corregido del alumno "+alumno.getNombre());
		
	}

	@Override
	public void revisarExamen(Alumno alumno) {
		System.out.println("Examen revisado del alumno "+alumno.getNombre());
	}

	@Override
	public void explicar() {
		System.out.println("Explicando...");
		
	}

}
