package Parcial2023T1;

import tp02.ejercicio2.*;
import tp02.ejercicio3.*;
import tp03.ejercicio1.*;
import tp04.ejercicio1.*;

public class ParcialArboles {
	private ArbolBinario<Integer> arbol;
	
	public ParcialArboles(ArbolBinario<Integer> arbol) {
		this.arbol = arbol;
	}
	
	public boolean isLeftTree(int num) {
		return isLeftTree(num, arbol);
	}
	private boolean isLeftTree(int num, ArbolBinario<Integer> a) {
		boolean aux = false;
		int cantIzq = -1;
		int cantDer = -1;
		if(a.getDato() == num) {
			if(a.tieneHijoIzquierdo()) {
				cantIzq = contarArboles(a.getHijoIzquierdo());
			}
			if(a.tieneHijoDerecho()) {
				cantDer = contarArboles(a.getHijoDerecho());
			}
			return(cantIzq > cantDer);
		}
		if((a.tieneHijoIzquierdo())&&(!aux)) {
			aux = isLeftTree(num, a.getHijoIzquierdo());
		}
		if((a.tieneHijoDerecho())&&(!aux)) {
			aux = isLeftTree(num, a.getHijoDerecho());
		}
		return aux;
	}
	private int contarArboles(ArbolBinario<Integer> a) {
		int contador = 0;
		if(((a.tieneHijoIzquierdo())&&(!a.tieneHijoDerecho()))||((a.tieneHijoDerecho())&&(!a.tieneHijoIzquierdo()))) {
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
