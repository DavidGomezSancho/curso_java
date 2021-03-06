package com.curso.java.ejercicio02lineaNegocio;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.java.ejercicio02DAO.IAulaDAO;
import com.curso.java.oo.model.Alumno;
import com.curso.java.oo.model.Aula;
import com.curso.java.oo.model.Persona;
import com.curso.java.oo.model.Profesor;
import com.curso.java.oo.model.PuestoDeTrabajo;

@Service("AulaLN")
public class AulaLN {
	
	@Autowired
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
		Collection<Aula> aulas = aulaDAO.getAulas();
		Map<String, List<Alumno>> alumnosPorAulas = new HashMap<String, List<Alumno>>();
		for (Aula currentAula : aulas) {
			List<Alumno> alumnos = new ArrayList<Alumno>();
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
	
	public Map<String, List<Profesor>> getProfesoresPorAulas(){
		Collection<Aula> aulas = aulaDAO.getAulas();
		Map<String, List<Profesor>> profesoresPorAulas = new HashMap<String, List<Profesor>>();
		for (Aula currentAula : aulas) {
			List<Profesor> profesores = new ArrayList<Profesor>();
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
	
	public Boolean putAlumnoAula(Alumno alumno, String nombreAula) {
		Collection<Aula> aulas= aulaDAO.getAulas();
		Aula aula = null;
		Boolean exito = new Boolean(false);
		for(Aula currentAula : aulas) {
			if(currentAula.getNombre().equals(nombreAula)) {
				aula = currentAula;
				break;
			}
		}
		
		if(aula==null)
			return exito;
		
		Set<PuestoDeTrabajo> puestosDeAlumnos = aula.getPuestoDeAlumnos();
		for(PuestoDeTrabajo puestoDeAlumno : puestosDeAlumnos) {
			if (puestoDeAlumno.getPersona() == null) {
				puestoDeAlumno.setPersona(alumno);
				if(aulaDAO.updateAula(aula)!=null) {
					exito = new Boolean(true);
				}
				break;
			}
		}
		return exito;
	}
	
	public Boolean eliminarAula(String nombreAula) {
		return aulaDAO.deleteAula(nombreAula);
	}
	
}
