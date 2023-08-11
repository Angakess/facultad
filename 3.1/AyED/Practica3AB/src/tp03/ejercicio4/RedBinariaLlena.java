package tp03.ejercicio4;

import tp03.ejercicio1.*;

public class RedBinariaLlena {
	private ArbolBinario<Integer> arbol = new ArbolBinario<Integer>();
	
	public RedBinariaLlena(ArbolBinario<Integer> arbol) {
		this.arbol = arbol;
	}
	
	public int retardoReenvio() {
		int total = 0;
		return	this.retardoReenvio(total, this.arbol);
	}
	private int retardoReenvio(int total, ArbolBinario<Integer> a) {
		int izq = 0;
		int der = 0;
		if(a.tieneHijoIzquierdo()) {
			izq = this.retardoReenvio(total,a.getHijoIzquierdo());
		}
		if(a.tieneHijoDerecho()) {
			der = this.retardoReenvio(total,a.getHijoDerecho());
		}
		if(izq > der) {
			total += izq;
			
		}
		else if(der > izq) {
			total += der;
		}
		return total + a.getDato();
	}
}
