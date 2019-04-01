package com.curso.java.web.controllers;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.curso.java.ejercicio02lineaNegocio.AulaLN;
import com.curso.java.oo.model.Alumno;
import com.curso.java.oo.model.PuestoDeTrabajo;

/**
 * Servlet implementation class EjemploServlet
 */
@WebServlet({ "/patatas", "/limones", "/springWeb" })
public class EjemploServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ApplicationContext applicationContext;
	
	
	
	@Override
	public void init() throws ServletException {
		
		ApplicationContext applicationContext = WebApplicationContextUtils
			.getRequiredWebApplicationContext(getServletContext());
		
		this.applicationContext = applicationContext;
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EjemploServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
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

		int i=0;
		for(Map.Entry<String, List<Alumno>> aulas : lineaNegocio.getAlumnosPorAulas().entrySet()) {
			for(Alumno alumno : aulas.getValue()) {
				i++;
				request.setAttribute("Alumno"+Integer.toString(i), alumno);
			}
		}
		
//		request.setAttribute("Alumno1", david);
//		request.setAttribute("Alumno2", jorge);
//		request.setAttribute("Alumno3", pepe);
		
//		request.setAttribute("mensajeSingleton", context.getBean("mensajeSingleton"));
//		request.setAttribute("mensajePrototype", context.getBean("mensajePrototype"));
//		request.setAttribute("mensajeRequest", context.getBean("mensajeRequest"));
//		request.setAttribute("mensajeSession", context.getBean("mensajeSession"));
		getServletContext().getRequestDispatcher("/WEB-INF/jsps/saludar.jsp").forward(request, response);
	}

}
