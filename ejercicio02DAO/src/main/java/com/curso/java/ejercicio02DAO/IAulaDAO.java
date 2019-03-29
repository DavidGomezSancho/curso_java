package com.curso.java.ejercicio02DAO;

import java.util.Collection;

import com.curso.java.oo.model.Aula;

public interface IAulaDAO {
	void createAula(Aula aula);
	Collection<Aula> getAulas();
	//List<Aula> getAulasList();
	//Map<String, Aula> getAulasMap();
	void updateAula(Aula aula);
	void deleteAula(String nombreAula);
	//Aula getAula(String nombreAula);
}
