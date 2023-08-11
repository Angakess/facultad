package tp03.ejercicio5;

import tp03.ejercicio1.*;
import tp02.ejercicio3.*;

public class ProfundidadDeArbolBinario {
	private ArbolBinario<Integer> arbol = new ArbolBinario<Integer>();

	public ProfundidadDeArbolBinario(ArbolBinario<Integer> arbol) {
		this.arbol = arbol;
	}
	
	public int sumaElementosProfundidad(int p) {
		int suma = 0;
		int nivel = 0;
		ArbolBinario<Integer> arbolAux = new ArbolBinario<Integer>();
		ColaGenerica<ArbolBinario<Integer>> cola = new ColaGenerica<ArbolBinario<Integer>>();
		
		if(this.arbol != null) {
			cola.encolar(this.arbol);
			cola.encolar(null);
			while((!cola.esVacia())&&(nivel <= p)) {
				arbolAux = cola.desencolar();
				if(arbolAux != null) {
					if(nivel == p) {
						suma += arbolAux.getDato();
					}
					if(arbolAux.tieneHijoIzquierdo()) {
						cola.encolar(arbolAux.getHijoIzquierdo());
					}
					if(arbolAux.tieneHijoDerecho()) {
						cola.encolar(arbolAux.getHijoDerecho());
					}
				}
				else if((!cola.esVacia())&&(arbolAux == null)) {
					cola.encolar(null);
					nivel += 1;
				}
			}
		}
		else {
			System.out.println("El arbol esta vacio");
		}
		return suma;
	}

}
