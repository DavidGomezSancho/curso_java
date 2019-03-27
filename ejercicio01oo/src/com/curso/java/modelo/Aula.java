package com.curso.java.modelo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class Aula {
	List<Material> materialesDelAula = new ArrayList<Material>();
	Set<Persona> personas = new HashSet<Persona>();
	
	public Aula (List<Material> materialesDelAula, Set<Persona> personas) {
		this.materialesDelAula = materialesDelAula;
		this.personas = personas;
	} 
}
