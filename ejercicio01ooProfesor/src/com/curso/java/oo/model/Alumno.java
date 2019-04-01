package com.curso.java.oo.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component(value = "alumno")
@Scope(value = "prototype")
public class Alumno extends Persona {
	
	@Value("true")
	private Boolean subvencionado;

	public Boolean isSubvencionado() {
		return subvencionado;
	}

	public void setSubvencionado(boolean subvencionado) {
		this.subvencionado = subvencionado;
	}
	
}
