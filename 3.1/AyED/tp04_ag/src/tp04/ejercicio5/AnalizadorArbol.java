package tp04.ejercicio5;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp02.ejercicio3.*;
import tp04.ejercicio1.*;

public class AnalizadorArbol {
	
	public double devolverMaximoPromedio (ArbolGeneral<Integer> arbol) {
		ColaGenerica<ArbolGeneral<Integer>> cola = new ColaGenerica<ArbolGeneral<Integer>>();
		ListaGenerica<ArbolGeneral<Integer>> hijos = new ListaEnlazadaGenerica<ArbolGeneral<Integer>>();
		double tNivel = 0;
		double cant = 0;
		double max = -1;
		cola.encolar(arbol);
		cola.encolar(null);
		while(!cola.esVacia()) {
			ArbolGeneral<Integer> aux = cola.desencolar();
			if(aux != null) {
				tNivel += aux.getDato();//.getTiempo();
				cant += 1;
				hijos = aux.getHijos();
				hijos.comenzar();
				while(!hijos.fin()) {
					cola.encolar(hijos.proximo());
				}
			}
			else {
				max = Math.max(tNivel/cant, max);
				tNivel = 0;
				cant = 0;
				if(!cola.esVacia()) {
					cola.encolar(null);
				}
			}
		}
		return max;
	}
}


