package Recuperatorio2023;

import tp04.ejercicio1.*;
import tp02.ejercicio2.*;
import tp02.ejercicio3.*;
import tp03.ejercicio1.*;



public class RecuT1 {

	private ArbolGeneral<Integer> arbol;
	
	public RecuT1(ArbolGeneral<Integer> arbol) {
		this.arbol = arbol;
	}
	
	public ListaGenerica<Integer> camino(int num){
		ListaGenerica<Integer> lista = new ListaEnlazadaGenerica<Integer>();
		ListaGenerica<Integer> caminoL = new ListaEnlazadaGenerica<Integer>();
		buscarCamino(num, lista, caminoL, arbol);
		return caminoL;
	}
	private void buscarCamino(int num, ListaGenerica<Integer> lista, ListaGenerica<Integer> caminoL, ArbolGeneral<Integer> a) {
		lista.agregarFinal(a.getDato());
		System.out.println(a.getDato());
		if((a.getDato() % num) == 0) {
			if(a.esHoja()) {
				clonar(lista, caminoL);
			}
			else {
				if(caminoL.esVacia()) {
					ListaGenerica<ArbolGeneral<Integer>> hijos = a.getHijos();
					hijos.comenzar();
					while((!hijos.fin())&&(caminoL.esVacia())) {
						buscarCamino(num, lista, caminoL, hijos.proximo());
						lista.eliminarEn(lista.tamanio());
					}
				}
			}
		}
	}
	private void clonar(ListaGenerica<Integer> lista, ListaGenerica<Integer> caminoL) {
		lista.comenzar();
		while(!lista.fin()) {
			int aux = lista.proximo();
			caminoL.agregarFinal(aux);
		}
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArbolGeneral<Integer> a1 = new ArbolGeneral<Integer>(10);
		ArbolGeneral<Integer> a2 = new ArbolGeneral<Integer>(8);
		ArbolGeneral<Integer> a3 = new ArbolGeneral<Integer>(42);
		ArbolGeneral<Integer> a4 = new ArbolGeneral<Integer>(5);
		ArbolGeneral<Integer> a5 = new ArbolGeneral<Integer>(9);
		ArbolGeneral<Integer> a6 = new ArbolGeneral<Integer>(22);
		ArbolGeneral<Integer> a7 = new ArbolGeneral<Integer>(19);
		ArbolGeneral<Integer> a8 = new ArbolGeneral<Integer>(-5);
		ArbolGeneral<Integer> a9 = new ArbolGeneral<Integer>(2);
		ArbolGeneral<Integer> a10 = new ArbolGeneral<Integer>(5);
		ArbolGeneral<Integer> a11 = new ArbolGeneral<Integer>(28);
		ArbolGeneral<Integer> a12 = new ArbolGeneral<Integer>(20);
		ArbolGeneral<Integer> a13 = new ArbolGeneral<Integer>(4);
		
		a1.agregarHijo(a2); a1.agregarHijo(a3); a1.agregarHijo(a4);
		a2.agregarHijo(a5); a2.agregarHijo(a6);
		a4.agregarHijo(a7); a4.agregarHijo(a8);
		a5.agregarHijo(a9); a5.agregarHijo(a10);
		a6.agregarHijo(a11); a6.agregarHijo(a12);
		a7.agregarHijo(a13);
		
		RecuT1 r = new RecuT1(a1);
		
		var lista = r.camino(3);
		
		System.out.println("----------------------------------");
		
		lista.comenzar();
		while(!lista.fin()) {
			System.out.println(lista.proximo());
		}
		
	}

}
