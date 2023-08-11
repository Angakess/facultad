package tp04.ejercicio1;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio3.*;
import tp02.ejercicio2.ListaGenerica;

public class ArbolGeneral<T> {

	private T dato;

	private ListaGenerica<ArbolGeneral<T>> hijos = new ListaEnlazadaGenerica<ArbolGeneral<T>>();

	public T getDato() {
		return dato;
	}

	public void setDato(T dato) {
		this.dato = dato;
	}

	public void setHijos(ListaGenerica<ArbolGeneral<T>> hijos) {
		if (hijos==null)
			this.hijos = new ListaEnlazadaGenerica<ArbolGeneral<T>>();
		else
			this.hijos = hijos;
	}

	public ArbolGeneral(T dato) {
		this.dato = dato;
	}

	public ArbolGeneral(T dato, ListaGenerica<ArbolGeneral<T>> hijos) {
		this(dato);
		if (hijos==null)
			this.hijos = new ListaEnlazadaGenerica<ArbolGeneral<T>>();
		else
			this.hijos = hijos;
	}

	public ListaGenerica<ArbolGeneral<T>> getHijos() {
		return this.hijos;
	}

	public void agregarHijo(ArbolGeneral<T> unHijo) {

		this.getHijos().agregarFinal(unHijo);
	}

	public boolean esHoja() {

		return !this.tieneHijos();
	}

	public boolean tieneHijos() {
		return !this.hijos.esVacia();
	}

	public boolean esVacio() {

		return this.dato == null && !this.tieneHijos();
	}



	public void eliminarHijo(ArbolGeneral<T> hijo) {
		if (this.tieneHijos()) {
			ListaGenerica<ArbolGeneral<T>> hijos = this.getHijos();
			if (hijos.incluye(hijo)) 
				hijos.eliminar(hijo);
		}
	}

	public ListaEnlazadaGenerica<T> preOrden() {
		return null;
	}

	public Integer altura() {
		// Falta implementar..
		ColaGenerica<ArbolGeneral<T>> cola = new ColaGenerica<ArbolGeneral<T>>();
		ListaGenerica<ArbolGeneral<T>> hijos = new ListaEnlazadaGenerica<ArbolGeneral<T>>();
		int altura = 0;
		cola.encolar(this);
		cola.encolar(null);
		while(!cola.esVacia()) {
			ArbolGeneral<T> arbol = cola.desencolar();
			if(arbol != null) {
				hijos = arbol.getHijos();
				hijos.comenzar();
				while(!hijos.fin()) {
					cola.encolar(hijos.proximo());
				}
			}
			else if(!cola.esVacia()) {
				altura += 1;
				cola.encolar(null);
			}
		}
		return altura;
	}

	public Integer nivel(T dato) {
		if (this.getDato() == dato)
			return 0;

		ColaGenerica<ArbolGeneral<T>> cola = new ColaGenerica<ArbolGeneral<T>>();
		ListaGenerica<ArbolGeneral<T>> hijos = new ListaEnlazadaGenerica<ArbolGeneral<T>>();
		int nivel = 0;
		cola.encolar(this);
		cola.encolar(null);
		while(!cola.esVacia()) {
			ArbolGeneral<T> arbol = cola.desencolar();
			if(arbol != null) {
				hijos = arbol.getHijos();
				hijos.comenzar();
				while(!hijos.fin()) {
					var hijo = hijos.proximo();
					if (hijo.getDato() == dato)
						return nivel + 1;
					cola.encolar(hijo);
				}
			}
			else if(!cola.esVacia()) {
				nivel += 1;
				cola.encolar(null);
			}
		}
		return -1;
	}

	public Integer ancho() {
		// Falta implementar..
		ColaGenerica<ArbolGeneral<T>> cola = new ColaGenerica<ArbolGeneral<T>>();
		ListaGenerica<ArbolGeneral<T>> hijos = new ListaEnlazadaGenerica<ArbolGeneral<T>>();
		int cant = 0;
		int max = -1;
		cola.encolar(this);
		cola.encolar(null);
		while(!cola.esVacia()) {
			ArbolGeneral<T> arbol = cola.desencolar();
			if(arbol != null) {
				cant += 1;
				hijos = arbol.getHijos();
				hijos.comenzar();
				while(!hijos.fin()) {
					cola.encolar(hijos.proximo());
				}
			}
			else{
				max = Math.max(cant, max);
				cant = 0;
				if(!cola.esVacia()) {
					cola.encolar(null);
				}
			}
		}
		return max;
	}

	public Boolean esAncestro(T a, T b) {
		ListaGenerica<ArbolGeneral<T>> hijos = new ListaEnlazadaGenerica<ArbolGeneral<T>>();
		if(this.getDato() == a) {
			return this.esAncestro(b);
		}		
		hijos = this.getHijos();
		hijos.comenzar();
		while(!hijos.fin()) {
			if(hijos.proximo().esAncestro(a, b)) {
				return true;
			}
		}
		return false;
	}
	private Boolean esAncestro(T b) {
		ListaGenerica<ArbolGeneral<T>> hijos = new ListaEnlazadaGenerica<ArbolGeneral<T>>();
		if(this.getDato() == b) {
			return true;
		}
		hijos = this.getHijos();
		hijos.comenzar();
		while(!hijos.fin()) {
			if(hijos.proximo().esAncestro(b)) {
				return true;
			}
		}
		return false;
	}
}