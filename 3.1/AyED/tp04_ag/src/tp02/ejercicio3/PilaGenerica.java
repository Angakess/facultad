package tp02.ejercicio3;

import tp02.ejercicio2.*;

public class PilaGenerica<T> {
	private ListaGenerica<T> datos = new ListaEnlazadaGenerica<T>();
	
	public void apilar (T dato) {
		datos.agregarInicio(dato);
	}
	public T tope() {
		return datos.elemento(1);
	}
	public T desapilar() {
		T d = this.tope();
		datos.eliminarEn(1);
		return d;
	}
	public boolean esVacia() {
		return datos.esVacia();
	}
}
