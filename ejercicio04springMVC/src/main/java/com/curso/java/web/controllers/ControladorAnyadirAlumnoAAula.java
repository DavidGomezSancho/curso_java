package com.curso.java.web.controllers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.curso.java.ejercicio02DAO.AulaDAOList;
import com.curso.java.ejercicio02lineaNegocio.AulaLN;
import com.curso.java.oo.model.Alumno;
import com.curso.java.oo.model.Aula;
import com.curso.java.oo.model.PuestoDeTrabajo;

@Controller
@Scope("session")
public class ControladorAnyadirAlumnoAAula {
	
	private AulaLN aulaLN;
	
	@RequestMapping("insertarAula")
	public ModelAndView verFormulario() {
		//Llamo al negocio y en el model and view le pongo  los datos.
		AulaDAOList aulaDAO = new AulaDAOList();
		aulaLN = new AulaLN(aulaDAO);
		Set<PuestoDeTrabajo> puestosDeAlumnos1 = new HashSet<PuestoDeTrabajo>();
		puestosDeAlumnos1.add(new PuestoDeTrabajo());
		puestosDeAlumnos1.add(new PuestoDeTrabajo());
		
		aulaDAO.setAulas(new ArrayList<Aula>());
		
		aulaLN.nuevoAula("Aula1", true, true, puestosDeAlumnos1);
		
		return new ModelAndView("introducirAlumnoAAula");
	}
	
	@RequestMapping("insertarAlumno")
	public ModelAndView insertaAlumno(
			@RequestParam("nombreAula") String nombreAula, @RequestParam("nombreAlumno") String nombreAlumno,
			HttpServletRequest request) {
		
		Alumno alumno = new Alumno();
		alumno.setNombre(nombreAlumno);
		Boolean exito=aulaLN.putAlumnoAula(alumno, nombreAula);
		
		ModelAndView modelAndView = new ModelAndView("infoInsercionAlumno");
		modelAndView.addObject("exitoInsercion",exito.booleanValue());
		return modelAndView;
		
	}
}
