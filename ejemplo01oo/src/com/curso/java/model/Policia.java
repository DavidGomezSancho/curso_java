package com.curso.java.model;

public class Policia extends Persona {
	private Integer numeroDePlaca;
	private CargoDePolicia cargo;
	//private int numeroDePlacaPrimitivo;
	//private Boolean booleano;
	//private boolean booleanoPrimitivo;
	public Integer getNumeroDePlaca() {
		return numeroDePlaca;
	}
	public void setNumeroDePlaca(Integer numeroDePlaca) {
		this.numeroDePlaca = numeroDePlaca;
	}
	public CargoDePolicia getCargo() {
		return cargo;
	}
	public void setCargo(CargoDePolicia cargo) {
		this.cargo = cargo;
	}
	

	
}
