package ParcialEjerc5;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp03.ejercicio1.ArbolBinario;

public class Parcial5_1 {

	public ListaEnlazadaGenerica<Integer> resolver(ArbolBinario<Integer> a){
		ListaEnlazadaGenerica<Integer> lista = new ListaEnlazadaGenerica<Integer>();
		resolver(a, lista);
		return lista;
		
	}
	private int resolver(ArbolBinario<Integer> a, ListaEnlazadaGenerica<Integer> lista) {
		int cantIzq = 0;
		int cantDer = 0;
		if(a.tieneHijoIzquierdo()) {
			cantIzq += resolver(a.getHijoIzquierdo(), lista) + 1;
		}
		if(a.tieneHijoDerecho()) {
			cantDer += resolver(a.getHijoDerecho(), lista) + 1;
		}
		if(cantIzq == cantDer) {
			lista.agregarFinal(a.getDato());
		}
		return (cantIzq + cantDer);
	}
	
	
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
		
		var lista = new Parcial5_1().resolver(a1);
		
		System.out.println("-----------------------");
		
		lista.comenzar();
		while(!lista.fin()) {
			System.out.println(lista.proximo());
		}
	}
}
