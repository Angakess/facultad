package tp04.ejercicio3;

import tp04.ejercicio1.*;
import tp02.ejercicio2.*;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArbolGeneral<Integer> a1 = new ArbolGeneral<Integer>(10);
		ArbolGeneral<Integer> a2 = new ArbolGeneral<Integer>(5);
		ArbolGeneral<Integer> a3 = new ArbolGeneral<Integer>(20);
		ArbolGeneral<Integer> a4 = new ArbolGeneral<Integer>(9);
		ArbolGeneral<Integer> a5 = new ArbolGeneral<Integer>(7);
		ArbolGeneral<Integer> a6 = new ArbolGeneral<Integer>(4);
		ArbolGeneral<Integer> a7 = new ArbolGeneral<Integer>(2);
		ArbolGeneral<Integer> a8 = new ArbolGeneral<Integer>(3);
		ArbolGeneral<Integer> a9 = new ArbolGeneral<Integer>(1);
		ArbolGeneral<Integer> a10 = new ArbolGeneral<Integer>(30);
		
		a2.agregarHijo(a5);	a2.agregarHijo(a6);
		a3.agregarHijo(a7);
		a4.agregarHijo(a8); a4.agregarHijo(a9); a4.agregarHijo(a10);
		a1.agregarHijo(a2); a1.agregarHijo(a3); a1.agregarHijo(a4);
		
		
		
		ListaGenerica<Integer> listaPre =  new ListaEnlazadaGenerica<Integer>();
		listaPre = RecorridosAG.numerosImparesMayoresQuePreOrden(a1, 0);
		ListaGenerica<Integer> listaPos =  new ListaEnlazadaGenerica<Integer>();
		listaPos = RecorridosAG.numerosImparesMayoresQuePostOrden(a1, 0);
		ListaGenerica<Integer> listaIN =  new ListaEnlazadaGenerica<Integer>();
		listaIN = RecorridosAG.numerosImparesMayoresQueInOrden(a1, 0);
		ListaGenerica<Integer> listaNivel =  new ListaEnlazadaGenerica<Integer>();
		listaNivel = RecorridosAG.numerosImparesMayoresQuePorNiveles(a1, 0);
		
		System.out.println("PREORDEN");
		listaPre.comenzar();
		while(!listaPre.fin()) {
			System.out.println(listaPre.proximo());
		}
		System.out.println("-----------------------------------------");
		System.out.println("POSTORDEN");
		listaPos.comenzar();
		while(!listaPos.fin()) {
			System.out.println(listaPos.proximo());
		}
		System.out.println("-----------------------------------------");
		System.out.println("INORDEN");
		listaIN.comenzar();
		while(!listaIN.fin()) {
			System.out.println(listaIN.proximo());
		}
		System.out.println("-----------------------------------------");
		System.out.println("POR NIVELES");
		listaNivel.comenzar();
		while(!listaNivel.fin()) {
			System.out.println(listaNivel.proximo());
			
		}

		
		System.out.println("altura: "+a1.altura());
		System.out.println("nivel del dato: "+a1.nivel(20));
		System.out.println("ancho maximo del arbol: "+a1.ancho());
	}

}
