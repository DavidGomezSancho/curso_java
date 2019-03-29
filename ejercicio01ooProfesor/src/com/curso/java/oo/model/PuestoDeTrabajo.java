package com.curso.java.oo.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "prototype")
public class PuestoDeTrabajo {
	
	@Value("true")
	private Boolean ordenador;

	private Persona persona;
	
	public PuestoDeTrabajo(){}
	public PuestoDeTrabajo(boolean ordenador) {
		this.ordenador = ordenador;
	}
	
	
	public Boolean getOrdenador() {
		return ordenador;
	}


	public void setOrdenador(Boolean ordenador) {
		this.ordenador = ordenador;
	}


	public Persona getPersona() {
		return persona;
	}
	public void setPersona(Persona persona) {
		this.persona = persona;
	}
	
}
