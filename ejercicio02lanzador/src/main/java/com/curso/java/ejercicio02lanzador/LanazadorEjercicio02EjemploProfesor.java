package com.curso.java.ejercicio02lanzador;

import java.util.ArrayList;
import java.util.Iterator;


public class LanazadorEjercicio02EjemploProfesor {

	public static void main(String[] args) {
		ArrayList<String> lista = new ArrayList<String>();
		lista.isEmpty();
		lista.size();
		//[primero]
		lista.add("primero");
		//
		lista.add("segundo");
		Iterator<String> miIteradorDeCadenas = lista.iterator();
		miIteradorDeCadenas.hasNext();//Si hay siquiente elemento
		String cadenaActual = miIteradorDeCadenas.next();
		
		//lista.forEach(
		//		(miCadena) -> {
		//			System.out.println(miCadena);
		//		}
		//);
		//lista. set, add, remove, contains(""), indexOf("") -> Donde esta, 
	}

}
