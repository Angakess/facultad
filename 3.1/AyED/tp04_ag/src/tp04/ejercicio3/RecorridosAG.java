package tp04.ejercicio3;

import tp02.ejercicio2.*;
import tp02.ejercicio3.*;
import tp04.ejercicio1.*;

public class RecorridosAG {
	
	public static ListaGenerica<Integer> numerosImparesMayoresQuePreOrden(ArbolGeneral<Integer> a, Integer n){
		ListaEnlazadaGenerica<Integer> lista = new ListaEnlazadaGenerica<Integer>();
		return numerosImparesMayoresQuePreOrden(lista, a, n);
	}
	private static ListaGenerica<Integer> numerosImparesMayoresQuePreOrden(ListaEnlazadaGenerica<Integer> lista, ArbolGeneral<Integer> a,Integer n){
		ListaGenerica<ArbolGeneral<Integer>> hijos = new ListaEnlazadaGenerica<ArbolGeneral<Integer>>();
		if(((a.getDato()%2) == 0 )&&(a.getDato() > n)) {
			lista.agregarFinal(a.getDato());
		}
		hijos = a.getHijos();
		hijos.comenzar();
		while(!hijos.fin()) {
			numerosImparesMayoresQuePreOrden(lista, hijos.proximo(), n);
		}
		return lista;
	}
	
	public static ListaGenerica<Integer> numerosImparesMayoresQueInOrden(ArbolGeneral<Integer> a, Integer n){
		ListaEnlazadaGenerica<Integer> lista = new ListaEnlazadaGenerica<Integer>();
		return numerosImparesMayoresQueInOrden(lista, a, n);
	}
	private static ListaGenerica<Integer> numerosImparesMayoresQueInOrden(ListaEnlazadaGenerica<Integer> lista, ArbolGeneral<Integer> a,Integer n){
		ListaGenerica<ArbolGeneral<Integer>> hijos = new ListaEnlazadaGenerica<ArbolGeneral<Integer>>();
		hijos = a.getHijos();
		hijos.comenzar();
		if(!hijos.esVacia()) {
			numerosImparesMayoresQueInOrden(lista, hijos.proximo(), n);
		}
		if(((a.getDato()%2) == 0 )&&(a.getDato() > n)) {
			lista.agregarFinal(a.getDato());
		}
		while(!hijos.fin()) {
			numerosImparesMayoresQueInOrden(lista, hijos.proximo(), n);
		}
		return lista;
	}
	
	public static ListaGenerica<Integer> numerosImparesMayoresQuePostOrden(ArbolGeneral<Integer> a, Integer n){
		ListaEnlazadaGenerica<Integer> lista = new ListaEnlazadaGenerica<Integer>();
		return numerosImparesMayoresQuePostOrden(lista, a, n);
	}
	private static ListaGenerica<Integer> numerosImparesMayoresQuePostOrden(ListaEnlazadaGenerica<Integer> lista, ArbolGeneral<Integer> a,Integer n){
		ListaGenerica<ArbolGeneral<Integer>> hijos = new ListaEnlazadaGenerica<ArbolGeneral<Integer>>();
		hijos = a.getHijos();
		hijos.comenzar();
		while(!hijos.fin()) {
			numerosImparesMayoresQuePostOrden(lista, hijos.proximo(), n);
		}
		if(((a.getDato()%2) == 0 )&&(a.getDato() > n)) {
			lista.agregarFinal(a.getDato());
		}
		return lista;
	}
	
	public static ListaGenerica<Integer> numerosImparesMayoresQuePorNiveles(ArbolGeneral<Integer> a, Integer n){
		ListaEnlazadaGenerica<Integer> lista = new ListaEnlazadaGenerica<Integer>();
		ColaGenerica<ArbolGeneral<Integer>> cola = new ColaGenerica<ArbolGeneral<Integer>>();
		ListaGenerica<ArbolGeneral<Integer>> hijos = new ListaEnlazadaGenerica<ArbolGeneral<Integer>>();
		ArbolGeneral<Integer> aux = new ArbolGeneral<Integer>(null);
		cola.encolar(a);
		while(!cola.esVacia()) {
			aux = cola.desencolar();
			if(((aux.getDato()%2) == 0 )&&(aux.getDato() > n)) {
				lista.agregarFinal(aux.getDato());
			}
			hijos = aux.getHijos();
			hijos.comenzar();
			while(!hijos.fin()) {
				cola.encolar(hijos.proximo());
			}
		}
		return lista;
	}
	
}
