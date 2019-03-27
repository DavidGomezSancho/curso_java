package com.curso.java.ejercicio02DAO;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.curso.java.oo.model.Alumno;
import com.curso.java.oo.model.Aula;

public class AulaDAOImpl implements IAulaDAO{
	
	private List<Alumno> alumnos;
	private Map<String, Aula> aulas;
	
	public void createAula(Aula aula) {
		//Iterator iterator = alumnos.iterator();
		aulas.put(aula.getNombre(), aula);
		System.out.println("Aula " + aula.getNombre() + " agregado");
	}
	
	public void updateAula(Aula aula) {
		
	}
	public void deleteAula(Aula aula) {
		
	}

	public List<Aula> getAulasList() {
		// TODO Auto-generated method stub
		return null;
	}

	public Map<String, Aula> getAulasMap() {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
