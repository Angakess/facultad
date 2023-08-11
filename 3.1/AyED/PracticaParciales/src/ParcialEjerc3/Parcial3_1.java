package ParcialEjerc3;

import tp04.ejercicio1.ArbolGeneral;
import tp02.ejercicio2.*;

public class Parcial3_1{
	
	private ArbolGeneral<Integer> arbol;
	
	public Parcial3_1(ArbolGeneral<Integer> arbol) {
		this.arbol = arbol;
	}
	
	public ListaGenerica<Integer> resolver(){
		ListaGenerica<Integer> lista = new ListaEnlazadaGenerica<Integer>();
		posOrden(lista, this.arbol);
		return lista;
	}
	private void posOrden(ListaGenerica<Integer> lista, ArbolGeneral<Integer> a) {
		ListaGenerica<ArbolGeneral<Integer>> hijos = a.getHijos();
		int suma = 0;
		boolean ok = false;
		hijos.comenzar();
		while(!hijos.fin()) {
			ArbolGeneral<Integer> aux = hijos.proximo();
			posOrden(lista, aux);
			if((hijos.tamanio() % 2) != 0) {
				suma += aux.getDato();
				ok = true;
			}
		}
		if(ok) {
			lista.agregarFinal(suma);
		}
		System.out.println(a.getDato());
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArbolGeneral<Integer> a1 = new ArbolGeneral<Integer>(2);
		ArbolGeneral<Integer> a2 = new ArbolGeneral<Integer>(1);
		ArbolGeneral<Integer> a3 = new ArbolGeneral<Integer>(12);
		ArbolGeneral<Integer> a4 = new ArbolGeneral<Integer>(14);
		ArbolGeneral<Integer> a5 = new ArbolGeneral<Integer>(5);
		ArbolGeneral<Integer> a6 = new ArbolGeneral<Integer>(4);
		ArbolGeneral<Integer> a7 = new ArbolGeneral<Integer>(8);
		ArbolGeneral<Integer> a8 = new ArbolGeneral<Integer>(4);
		ArbolGeneral<Integer> a9 = new ArbolGeneral<Integer>(7);
		ArbolGeneral<Integer> a10 = new ArbolGeneral<Integer>(9);
		ArbolGeneral<Integer> a11 = new ArbolGeneral<Integer>(10);
		ArbolGeneral<Integer> a12 = new ArbolGeneral<Integer>(5);
		ArbolGeneral<Integer> a13 = new ArbolGeneral<Integer>(3);
		ArbolGeneral<Integer> a14 = new ArbolGeneral<Integer>(13);
		
		a1.agregarHijo(a2); a1.agregarHijo(a3); a1.agregarHijo(a4);
		a2.agregarHijo(a5); a2.agregarHijo(a6);
		a3.agregarHijo(a7); a3.agregarHijo(a8); a3.agregarHijo(a9);
		a6.agregarHijo(a10); a6.agregarHijo(a11); a6.agregarHijo(a12);
		a7.agregarHijo(a13);
		a9.agregarHijo(a14);
		
		var lista = new Parcial3_1(a1).resolver();
		
		lista.comenzar();
		while(!lista.fin()) {
			System.out.println(lista.proximo());
		}
	}
}
