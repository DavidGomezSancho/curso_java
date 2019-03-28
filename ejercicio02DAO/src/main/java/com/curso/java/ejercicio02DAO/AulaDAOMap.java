package com.curso.java.ejercicio02DAO;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.curso.java.oo.model.Aula;

public class AulaDAOMap implements IAulaDAO{

	Map<String, Aula> aulas = new HashMap<String, Aula>();
	
	public void createAula(Aula aula) {
		aulas.put(aula.getNombre(), aula);
		System.out.println("Aula creada: "+aula);
	}

	public Collection<Aula> getAulas() {
		return aulas.values();
	}

	public void updateAula(Aula aula) {
		aulas.remove(aula.getNombre());
		aulas.put(aula.getNombre(), aula);
		System.out.println("Aula actualizada: "+aula);
	}

	public void deleteAula(String nombreAula) {
		aulas.remove(nombreAula);
		System.out.println("Aula eliminada: "+nombreAula);
	}

}
