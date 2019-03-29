package com.curso.java.ejercicio02lanzador;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.curso.java.ejercicio02lineaNegocio.AulaLN;
import com.curso.java.oo.model.Alumno;
import com.curso.java.oo.model.Profesor;
import com.curso.java.oo.model.PuestoDeTrabajo;

public class lanzadorEjercicio02Lista {
	
	public static ApplicationContext applicationContext;
	
	static {
		applicationContext = new ClassPathXmlApplicationContext("beanInstanciaDAO.xml");
	}
	
	public static void main(String[] args) {
//		ApplicationContext applicationContext = 
//				new ClassPathXmlApplicationContext("beanInstanciaDAO.xml");
		
		//IAulaDAO estaEsMiImplementacionDeLaInterfazAulaDao =  applicationContext.getBean("aulaDAO", IAulaDAO.class);
		//AulaDAOList estaEsMiImplementacionDeLaInterfazAulaDaoList = new AulaDAOList();
		
		//AulaLN lineaNegocio = applicationContext.getBean("aulaLNBean", AulaLN.class);
		AulaLN lineaNegocio = applicationContext.getBean("AulaLN",AulaLN.class);
		
		
		Set<PuestoDeTrabajo> puestosDeAlumnos1 = (Set<PuestoDeTrabajo>) applicationContext.getBean("puestosDeTrabajo");
		puestosDeAlumnos1.add(applicationContext.getBean(PuestoDeTrabajo.class));
		puestosDeAlumnos1.add(applicationContext.getBean(PuestoDeTrabajo.class));
		puestosDeAlumnos1.add(applicationContext.getBean(PuestoDeTrabajo.class));
		
		Set<PuestoDeTrabajo> puestosDeAlumnos2 = (Set<PuestoDeTrabajo>) applicationContext.getBean("puestosDeTrabajo");
		puestosDeAlumnos2.add(applicationContext.getBean(PuestoDeTrabajo.class));
		puestosDeAlumnos2.add(applicationContext.getBean(PuestoDeTrabajo.class));
		
		lineaNegocio.nuevoAula("Aula1", true, true, puestosDeAlumnos1);
		
		lineaNegocio.nuevoAula("Aula2", false, true, puestosDeAlumnos2);
		
		Alumno david = applicationContext.getBean("alumno", Alumno.class);
		david.setNombre("David");
		Alumno jorge = applicationContext.getBean("alumno", Alumno.class);
		jorge.setNombre("Jorge");
		
		lineaNegocio.putAlumnoAula(david, "Aula1");
		lineaNegocio.putAlumnoAula(jorge, "Aula1");
		
		Alumno pepe = applicationContext.getBean("alumno", Alumno.class);
		pepe.setNombre("Pepe");
		lineaNegocio.putAlumnoAula(pepe, "Aula2");
		
		lineaNegocio.nuevoAula("Aula3", false, true, puestosDeAlumnos2);
		lineaNegocio.eliminarAula("Aula3");

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
