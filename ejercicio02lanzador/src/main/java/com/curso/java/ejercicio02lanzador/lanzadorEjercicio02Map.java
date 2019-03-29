package com.curso.java.ejercicio02lanzador;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.curso.java.ejercicio02DAO.AulaDAOMap;
import com.curso.java.ejercicio02lineaNegocio.AulaLN;
import com.curso.java.oo.model.Alumno;
import com.curso.java.oo.model.Profesor;
import com.curso.java.oo.model.PuestoDeTrabajo;

public class lanzadorEjercicio02Map {

	public static void main(String[] args) {
		AulaDAOMap iMap = new AulaDAOMap();
		AulaLN lineaNegocio = new AulaLN(iMap);
		
		Set<PuestoDeTrabajo> puestosDeAlumnos1 = new HashSet<PuestoDeTrabajo>();
//		puestosDeAlumnos1.add(new PuestoDeTrabajo(true));
//		puestosDeAlumnos1.add(new PuestoDeTrabajo(true));
//		puestosDeAlumnos1.add(new PuestoDeTrabajo(false));
//		
//		Set<PuestoDeTrabajo> puestosDeAlumnos2 = new HashSet<PuestoDeTrabajo>();
//		puestosDeAlumnos2.add(new PuestoDeTrabajo(true));
//		puestosDeAlumnos2.add(new PuestoDeTrabajo(true));
		
//		lineaNegocio.nuevoAula("Aula1", true, true, puestosDeAlumnos1);
//		
//		lineaNegocio.nuevoAula("Aula2", false, true, puestosDeAlumnos2);
//		
//		Alumno david = new Alumno();
//		david.setNombre("David");
//		Alumno jorge = new Alumno();
//		jorge.setNombre("Jorge");
//		Profesor profesor1 = new Profesor();
//		profesor1.setNombre("Profesor");
//		lineaNegocio.putAlumnoAula(david, "Aula1");
//		lineaNegocio.putAlumnoAula(jorge, "Aula1");
//		
//		Alumno pepe = new Alumno();
//		pepe.setNombre("Pepe");
//		lineaNegocio.putAlumnoAula(pepe, "Aula2");
//		
//		lineaNegocio.nuevoAula("Aula3", false, true, puestosDeAlumnos2);
//		lineaNegocio.eliminarAula("Aula3");

		System.out.println("--------------------------");
		for(Map.Entry<String, List<Alumno>> aulas : lineaNegocio.getAlumnosPorAulas().entrySet()) {
			System.out.println("Aula: " + aulas.getKey());
			for(Alumno alumno : aulas.getValue()) {
				System.out.println(alumno.getNombre());
			}
			System.out.println("--------------------------");
		}
	}

}
