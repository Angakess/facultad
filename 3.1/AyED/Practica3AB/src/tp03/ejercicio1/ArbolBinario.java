package tp03.ejercicio1;

import tp02.ejercicio3.*;

public class ArbolBinario<T> {
	private T dato;
	private ArbolBinario<T> hijoIzquierdo;   
	private ArbolBinario<T> hijoDerecho; 

	
	public ArbolBinario() {
		super();
	}

	public ArbolBinario(T dato) {
		this.dato = dato;
	}

	/*
	 * getters y setters
	 * 
	 */
	public T getDato() {
		return dato;
	}

	public void setDato(T dato) {
		this.dato = dato;
	}
	
	/**
	 * Preguntar antes de invocar si tieneHijoIzquierdo()
	 * @return
	 */
	public ArbolBinario<T> getHijoIzquierdo() {
		return this.hijoIzquierdo;
	}

	public ArbolBinario<T> getHijoDerecho() {
		return this.hijoDerecho;

	}

	public void agregarHijoIzquierdo(ArbolBinario<T> hijo) {
		this.hijoIzquierdo = hijo;
	}

	public void agregarHijoDerecho(ArbolBinario<T> hijo) {
		this.hijoDerecho = hijo;
	}

	public void eliminarHijoIzquierdo() {
		this.hijoIzquierdo = null;
	}

	public void eliminarHijoDerecho() {
		this.hijoDerecho = null;
	}

	public boolean esVacio() {
		return this.getDato() == null && !this.tieneHijoIzquierdo() && !this.tieneHijoDerecho();
	}

	public boolean esHoja() {
		return (!this.tieneHijoIzquierdo() && !this.tieneHijoDerecho());

	}

	@Override
	public String toString() {
		return this.getDato().toString();
	}

	 
	public boolean tieneHijoIzquierdo() {
		return this.hijoIzquierdo!=null;
	}

	 
	public boolean tieneHijoDerecho() {
		return this.hijoDerecho!=null;
	}

	public int contarHojas() {
		int cant = 0;
		return this.contarHojasR(cant);
	}
	private int contarHojasR(int cant) {
		cant += 1;
		if(this.tieneHijoIzquierdo()) {
			cant = this.getHijoIzquierdo().contarHojasR(cant);
		}
		if(this.tieneHijoDerecho()) {
			cant = this.getHijoDerecho().contarHojasR(cant);
		}
		return cant;
	}
	

    public ArbolBinario<T> espejo() {
		ArbolBinario<T> a = new ArbolBinario<T>();
		return this.espejo(a);
	}
    private ArbolBinario<T> espejo(ArbolBinario<T> a){
    	a.setDato(this.getDato());
    	if (this.tieneHijoIzquierdo()) {
    		a.agregarHijoDerecho(new ArbolBinario<T>());
    		this.getHijoIzquierdo().espejo(a.getHijoDerecho());
    	}
    	if (this.tieneHijoDerecho()) {
    		a.agregarHijoIzquierdo(new ArbolBinario<T>());
    		this.getHijoDerecho().espejo(a.getHijoIzquierdo());
    	}
    	return a;
    }


	public void entreNiveles(int n, int m){
		if(n <= m) {	
			ArbolBinario<T> arbol = null;
			int nivel = 0;
			ColaGenerica<ArbolBinario<T>> cola = new ColaGenerica<ArbolBinario<T>>();
			cola.encolar(this);
			cola.encolar(null);
			while(!cola.esVacia()) {
				arbol = cola.desencolar();
				if(arbol != null) {
					if((nivel >= n)&&(nivel <= m)) {
						System.out.println(arbol.getDato()+" (nivel: "+nivel+")");
					}
					if(arbol.tieneHijoIzquierdo()) {
						cola.encolar(arbol.getHijoIzquierdo());
					}
					if(arbol.tieneHijoDerecho()) {
						cola.encolar(arbol.getHijoDerecho());
					}
				}
				else if(!cola.esVacia()) {
					nivel += 1;
					cola.encolar(null);
				}
			}
		}
		else {
			System.out.println("El valor minimo supero el valor maximo");
		}
	}
	public void printEnOrden() {
		if(this.tieneHijoIzquierdo()) {
			this.getHijoIzquierdo().printEnOrden();
		}
		System.out.println(this.getDato());
		if(this.tieneHijoDerecho()) {
			this.getHijoDerecho().printEnOrden();
		}
	}
	

}
