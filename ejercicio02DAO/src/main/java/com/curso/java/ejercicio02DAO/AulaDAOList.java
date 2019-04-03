package com.curso.java.ejercicio02DAO;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.curso.java.oo.model.Aula;

@Repository
public class AulaDAOList implements IAulaDAO{
	
	@Autowired
	@Qualifier("aulas")
	private List<Aula> aulas ;
	
	public Aula createAula(Aula aula) {
		aulas.add(aula);
		System.out.println("Aula creada: "+aula);
		return aula;
	}

	

	public Aula updateAula(Aula aula) {
		for(Aula currentAula : aulas) {
			if(currentAula.getNombre().equals(aula.getNombre())) {
				aulas.remove(currentAula);
				aulas.add(aula);
				System.out.println("Aula actualizada: "+aula);
				return aula;
			}
		}
		return null;
	}

	public Boolean deleteAula(String nombreAula) {
		Boolean exito = new Boolean(false);
		for(Aula currentAula : aulas) {
			if(currentAula.getNombre().equals(nombreAula)) {
				aulas.remove(currentAula);
				System.out.println("Aula eliminada: "+nombreAula);
				exito=new Boolean(true);
				break;
			}
		}
		return exito;
	}

	@Override
	public Aula getAula(String aula) {
		Aula returnAula=null;
		for(Aula currentAula : aulas) {
			if(currentAula.getNombre().equals(aula)) {
				returnAula=currentAula;
				break;
			}
		}
		return returnAula;
	}
	
	public Collection<Aula> getAulas() {
		return aulas;
	}
	public void setAulas(List<Aula> aulas) {
		this.aulas = aulas;
	}
}
