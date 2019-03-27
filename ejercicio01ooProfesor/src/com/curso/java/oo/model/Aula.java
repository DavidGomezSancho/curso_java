package com.curso.java.oo.model;

import java.util.HashSet;
import java.util.Set;

public class Aula {
	private String nombre;
	private boolean proyector;
	private boolean pizarra;
	private PuestoDeTrabajo puestoDelProfesor;
	private Set<PuestoDeTrabajo> puestoDeAlumnos;

	public Aula(String nombre, boolean proyector, boolean pizarra) {
		super();
		this.nombre = nombre;
		this.proyector = proyector;
		this.pizarra = pizarra;
		this.puestoDeAlumnos = new HashSet<PuestoDeTrabajo>();
	}
	
	public Aula(String nombre, boolean proyector, boolean pizarra,  Set<PuestoDeTrabajo> puestoDeAlumnos) {
		super();
		this.nombre = nombre;
		this.proyector = proyector;
		this.pizarra = pizarra;
		this.puestoDeAlumnos = puestoDeAlumnos;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public boolean isProyector() {
		return proyector;
	}
	public void setProyector(boolean proyector) {
		this.proyector = proyector;
	}
	public boolean isPizarra() {
		return pizarra;
	}
	public void setPizarra(boolean pizarra) {
		this.pizarra = pizarra;
	}
	public PuestoDeTrabajo getPuestoDelProfesor() {
		return puestoDelProfesor;
	}
	public void setPuestoDelProfesor(PuestoDeTrabajo puestoDelProfesor) {
		this.puestoDelProfesor = puestoDelProfesor;
	}
	public Set<PuestoDeTrabajo> getPuestoDeAlumnos() {
		return puestoDeAlumnos;
	}
	public void setPuestoDeAlumnos(Set<PuestoDeTrabajo> puestoDeAlumnos) {
		this.puestoDeAlumnos = puestoDeAlumnos;
	}
	
}
