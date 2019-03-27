package com.curso.java.model;

import java.io.Serializable;

public class PoliciaPistolero extends Policia implements PuedeDisparar, Serializable{
	private String pistolon;

	public String getPistolon() {
		return pistolon;
	}

	public void setPistolon(String pistolon) {
		this.pistolon = pistolon;
	}
	
	public void dispararSinJuicio(String objetivo) {
		// TODO Auto-generated method stub
		System.out.println("Disparando con " + pistolon + "a" + objetivo);
	}
	
}
