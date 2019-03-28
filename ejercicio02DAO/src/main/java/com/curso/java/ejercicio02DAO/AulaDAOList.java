package com.curso.java.ejercicio02DAO;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.curso.java.oo.model.Aula;

public class AulaDAOList implements IAulaDAO{
	
	
	private List<Aula> aulas ;
	//= new ArrayList<Aula>()
	
	public void createAula(Aula aula) {
		aulas.add(aula);
		System.out.println("Aula creada: "+aula);
	}

	public Collection<Aula> getAulas() {
		return aulas;
	}

	public void updateAula(Aula aula) {
		for(Aula currentAula : aulas) {
			if(currentAula.getNombre().equals(aula.getNombre())) {
				aulas.remove(currentAula);
				aulas.add(aula);
				System.out.println("Aula actualizada: "+aula);
				break;
			}
		}
		
	}

	public void deleteAula(String nombreAula) {
		for(Aula currentAula : aulas) {
			if(currentAula.getNombre().equals(nombreAula)) {
				aulas.remove(currentAula);
				System.out.println("Aula eliminada: "+nombreAula);
				break;
			}
		}
		
	}

	public void setAulas(List<Aula> aulas) {
		this.aulas = aulas;
	}
	
	

}
