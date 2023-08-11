package ej02;

import tp02.ejercicio2.*;


public class TestListaEnlazadaGenerica {

	public static void main(String[] args) {
		Estudiante e1 = new Estudiante();
		Estudiante e2 = new Estudiante();
		Estudiante e3 = new Estudiante();
		Estudiante e4 = new Estudiante();
		
		e1.setNombre("aaaa");
		e2.setNombre("bbb");
		e3.setNombre("ccc");
		e4.setNombre("ddd");
		
		ListaEnlazadaGenerica<Estudiante> lEstudiantes = new ListaEnlazadaGenerica<Estudiante>();
		
		lEstudiantes.agregarFinal(e1);
		lEstudiantes.agregarFinal(e2);
		lEstudiantes.agregarFinal(e3);
		lEstudiantes.agregarFinal(e4);
		
		lEstudiantes.comenzar();
		while(!lEstudiantes.fin()) {
			System.out.println(lEstudiantes.proximo().tusDatos());
		}
	}
}
