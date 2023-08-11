package ParcialEjerc5;

import tp02.ejercicio2.*;
import tp02.ejercicio3.*;
import tp03.ejercicio1.*;
import tp04.ejercicio1.*;

public class Parcial5 {
	
	public ListaGenerica<Integer> resolver(ArbolBinario<Integer> arbol){
		ListaGenerica<Integer> lista = new ListaEnlazadaGenerica<Integer>();
		resolver(lista, arbol);
		return lista;
	}
	private static Integer resolver(ListaGenerica<Integer> l, ArbolBinario<Integer> a) {
		int contador = 0;
		int cantIzq = 0;
		int cantDer = 0;
			if(a.tieneHijoIzquierdo()) {
				cantIzq += resolver(l,a.getHijoIzquierdo());
				contador += cantIzq;
				
			}
			if(a.tieneHijoDerecho()) {
				cantDer += resolver(l,a.getHijoDerecho());
				contador += cantDer;
				
			}
			if(cantIzq == cantDer) {
				l.agregarFinal(a.getDato());
			}
		return contador + 1;
	}
	/*
	 *private Integer resolver (ArbolBinario<Integer> a, ListaGenerica<Integer>l) {
		int cant = 0;
		int cantizq = 0;
		int cantder = 0;
		
		if (a.esHoja()) 
			l.agregarFinal(a.getDato());
		else {
			if (a.tieneHijoIzquierdo()) {
				cantizq+= resolver(a.getHijoIzquierdo(),l);
				cant+= cantizq;
			}
			if (a.tieneHijoDerecho()) {
				cantder+= resolver(a.getHijoDerecho(),l);
				cant+=cantder;
			}
			if (cantder == cantizq)
				l.agregarFinal(a.getDato());
		}
		return cant + 1;
	}
	 */
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArbolBinario<Integer> a1 = new ArbolBinario<Integer>(2);
		ArbolBinario<Integer> a2 = new ArbolBinario<Integer>(1);
		ArbolBinario<Integer> a3 = new ArbolBinario<Integer>(5);
		ArbolBinario<Integer> a4 = new ArbolBinario<Integer>(16);
		ArbolBinario<Integer> a5 = new ArbolBinario<Integer>(6);
		ArbolBinario<Integer> a6 = new ArbolBinario<Integer>(8);
		ArbolBinario<Integer> a7 = new ArbolBinario<Integer>(22);
		
		a1.agregarHijoIzquierdo(a2); a1.agregarHijoDerecho(a3);
		a2.agregarHijoIzquierdo(a4); a2.agregarHijoDerecho(a5);
		a3.agregarHijoDerecho(a6);
		a6.agregarHijoIzquierdo(a7);
		
		var lista = new Parcial5().resolver(a1);
		
		lista.comenzar();
		while(!lista.fin()) {
			System.out.println(lista.proximo());
		}
	}

}
