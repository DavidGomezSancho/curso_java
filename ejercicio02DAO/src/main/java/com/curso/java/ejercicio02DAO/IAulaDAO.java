package com.curso.java.ejercicio02DAO;

import java.util.Collection;

import com.curso.java.oo.model.Aula;

public interface IAulaDAO {
	Aula createAula(Aula aula);
	Collection<Aula> getAulas();
	//List<Aula> getAulasList();
	//Map<String, Aula> getAulasMap();
	Aula updateAula(Aula aula);
	Boolean deleteAula(String nombreAula);
	Aula getAula(String nombreAula);
}
