package test;

import tp02.ejercicio2.*;
import tp03.ejercicio3.*;
import tp03.ejercicio1.*;

public class principal {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArbolBinario<Integer> a = new ArbolBinario<Integer>(8);
		
		a.agregarHijoIzquierdo(new ArbolBinario<Integer>(2));
		a.agregarHijoDerecho(new ArbolBinario<Integer>(3));
		a.getHijoIzquierdo().agregarHijoIzquierdo(new ArbolBinario<Integer>(4));
		a.getHijoIzquierdo().agregarHijoDerecho(new ArbolBinario<Integer>(5));
		a.getHijoDerecho().agregarHijoIzquierdo(new ArbolBinario<Integer>(6));
		
		ContadorArbol c = new ContadorArbol(a);
		/*
		System.out.println("Cantidad de nodos: "+a.contarHojas());
		System.out.println("----------------------------");
		a.printEnOrden();
		System.out.println("----------------------------");
		a.espejo().printEnOrden();
		
		a.entreNiveles(2, 1);
		*/
		var lista = c.numerosParesIO();
		lista.comenzar();
		while (!lista.fin()) {
			System.out.println(lista.proximo());
		}
		System.out.println("-----------------------");
		
		var lista2 = c.numerosParesPos();
		lista2.comenzar();
		while (!lista2.fin()) {
			System.out.println(lista2.proximo());
		}
	}

}
