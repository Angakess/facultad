package tp02.ejercicio3;

import tp02.ejercicio2.*;

public class ColaGenerica<T>{
	private ListaGenerica<T> datos = new ListaEnlazadaGenerica<T>();
	
	public void encolar (T dato) {
		datos.agregarFinal(dato);
	}	
	public T tope() {
		return datos.elemento(1);
	}
	public T desencolar() {
		T d = this.tope();
		datos.eliminarEn(1);
		return d;
	}
	public boolean esVacia() {
		return datos.esVacia();
	}
}
