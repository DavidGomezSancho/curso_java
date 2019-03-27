package com.curso.java.ejercicio02lineaNegocio;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.text.html.HTMLDocument.Iterator;

import com.curso.java.ejercicio02DAO.IAulaDAO;
import com.curso.java.oo.model.Alumno;
import com.curso.java.oo.model.Aula;
import com.curso.java.oo.model.Persona;
import com.curso.java.oo.model.Profesor;
import com.curso.java.oo.model.PuestoDeTrabajo;

public class AulaLN {
	private IAulaDAO aulaDAO;
	
	public AulaLN (IAulaDAO aulaDAO) {
		super();
		this.aulaDAO = aulaDAO;
	}
	
	public Aula nuevoAula(String nombre, boolean proyector, boolean pizarra,  Set<PuestoDeTrabajo> puestoDeAlumnos) {
		Aula aula = new Aula(nombre, proyector, pizarra, puestoDeAlumnos);
		aulaDAO.createAula(aula);
		return aula;
	}
	
	public Map<String, List<Alumno>> getAlumnosPorAulas(){
		List<Aula> aulas = aulaDAO.getAulasList();
		Map<String, List<Alumno>> alumnosPorAulas = new HashMap<String, List<Alumno>>();
		Persona personaPuestoProfesor = null;
		for (Aula currentAula : aulas) {
			List<Alumno> alumnos = new ArrayList<Alumno>();
			personaPuestoProfesor = currentAula.getPuestoDelProfesor().getPersona();
			if(personaPuestoProfesor instanceof Alumno) {
				alumnos.add((Alumno)personaPuestoProfesor);
			}
			for(PuestoDeTrabajo currentPuesto : currentAula.getPuestoDeAlumnos()) {
				Persona currentPersona = currentPuesto.getPersona();
				if (currentPersona instanceof Alumno) {
					alumnos.add((Alumno)currentPersona);
				}
			}
			alumnosPorAulas.put(currentAula.getNombre(), alumnos);
		}
		return alumnosPorAulas;
	}
	
	public Map<String, Collection<Profesor>> getProfesoresPorAulas(){
		List<Aula> aulas = aulaDAO.getAulasList();
		Map<String, Collection<Profesor>> profesoresPorAulas = new HashMap<String, Collection<Profesor>>();
		Persona personaPuestoProfesor = null;
		for (Aula currentAula : aulas) {
			List<Profesor> profesores = new ArrayList<Profesor>();
			personaPuestoProfesor = currentAula.getPuestoDelProfesor().getPersona();
			if(personaPuestoProfesor instanceof Profesor) {
				profesores.add((Profesor)personaPuestoProfesor);
			}
			for(PuestoDeTrabajo currentPuesto : currentAula.getPuestoDeAlumnos()) {
				Persona currentPersona = currentPuesto.getPersona();
				if (currentPersona instanceof Profesor) {
					profesores.add((Profesor)currentPersona);
				}
			}
			profesoresPorAulas.put(currentAula.getNombre(), profesores);
		}
		return profesoresPorAulas;
	}
	
	public void putAlumnoAula(Alumno alumno, String nombreAula) {
		Map<String, Aula> aulasMap= aulaDAO.getAulasMap();
		Aula aula = aulasMap.get(nombreAula);
		Set<PuestoDeTrabajo> puestosDeAlumnos = aula.getPuestoDeAlumnos();
		for(PuestoDeTrabajo puestoDeAlumno : puestosDeAlumnos) {
			if (puestoDeAlumno.getPersona() != null) {
				puestoDeAlumno.setPersona(alumno);
				aulaDAO.updateAula(aula);
				break;
			}
		}
		
	}
	
	public void eliminarAula(String nombreAula) {
		aulaDAO.deleteAula(nombreAula);
	}
	
}