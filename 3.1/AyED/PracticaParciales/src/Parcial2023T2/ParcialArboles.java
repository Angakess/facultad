package Parcial2023T2;

import tp02.ejercicio2.*;
import tp02.ejercicio3.*;
import tp03.ejercicio1.*;
import tp04.ejercicio1.*;

public class ParcialArboles {
	private ArbolBinario<Integer> arbol;
	
	public ParcialArboles(ArbolBinario<Integer> arbol) {
		this.arbol = arbol;
	}
	
	public Boolean isTwoTree(int num) {
		Boolean aux = false;
		return isTwoTree(num, arbol, aux);
	}
	private Boolean isTwoTree(int num, ArbolBinario<Integer> a, Boolean aux) {
		System.out.println(a.getDato());
		int cantIzq = -1;
		int cantDer = -1;
		if(a.getDato() == num) {
			if(a.tieneHijoIzquierdo()) {
				cantIzq = contarArboles(a.getHijoIzquierdo());
			}
			if(a.tieneHijoDerecho()) {
				cantDer = contarArboles(a.getHijoDerecho());
			}
			return (cantIzq == cantDer);
		}
		if((a.tieneHijoIzquierdo())&&(!aux)) {
			aux = isTwoTree(num, a.getHijoIzquierdo(), aux);
		}
		if((a.tieneHijoDerecho())&&(!aux)) {
			aux = isTwoTree(num, a.getHijoDerecho(), aux);
		}
		return aux;
	}
	private int contarArboles(ArbolBinario<Integer> a) {
		int contador = 0;
		if((a.tieneHijoIzquierdo())&&(a.tieneHijoDerecho())) {
			contador++;
		}
		if(a.tieneHijoIzquierdo()) {
			contador += contarArboles(a.getHijoIzquierdo());
		}
		if(a.tieneHijoDerecho()) {
			contador += contarArboles(a.getHijoDerecho());
		}
		return contador;
	}
	
}
