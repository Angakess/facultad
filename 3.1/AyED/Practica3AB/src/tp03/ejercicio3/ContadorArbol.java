package tp03.ejercicio3;

import tp03.ejercicio1.*;
import tp02.ejercicio2.*;

public class ContadorArbol {
	private ArbolBinario<Integer> arbol = new ArbolBinario<Integer>();
	
	public ContadorArbol(ArbolBinario<Integer> a) {
		this.arbol = a;
	}

	public ListaEnlazadaGenerica<Integer> numerosParesIO(){
		ListaEnlazadaGenerica<Integer> lista = new ListaEnlazadaGenerica<Integer>();
		return this.numerosParesIO(lista,this.arbol);
	}
	private ListaEnlazadaGenerica<Integer> numerosParesIO(ListaEnlazadaGenerica<Integer> l, ArbolBinario<Integer> a){
		if(a.tieneHijoIzquierdo()) {
			this.numerosParesIO(l,a.getHijoIzquierdo());
		}
		if(a.getDato() % 2 == 0) {
			l.agregarFinal(a.getDato());
		}
		if(a.tieneHijoDerecho()) {
			this.numerosParesIO(l,a.getHijoDerecho());
		}
		return l;
	}
	
	public ListaEnlazadaGenerica<Integer> numerosParesPos(){
		ListaEnlazadaGenerica<Integer> lista = new ListaEnlazadaGenerica<Integer>();
		return this.numerosParesPos(lista,this.arbol);
	}
	private ListaEnlazadaGenerica<Integer> numerosParesPos(ListaEnlazadaGenerica<Integer> l, ArbolBinario<Integer> a){
		if(a.tieneHijoIzquierdo()) {
			this.numerosParesPos(l,a.getHijoIzquierdo());
		}
		if(a.tieneHijoDerecho()) {
			this.numerosParesPos(l,a.getHijoDerecho());
		}
		if(a.getDato() % 2 == 0) {
			l.agregarFinal(a.getDato());
		}
		return l;
	}
	
	
	

}
