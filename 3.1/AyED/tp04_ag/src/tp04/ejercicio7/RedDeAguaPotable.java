package tp04.ejercicio7;

import tp04.ejercicio1.*;
import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp02.ejercicio3.*;

public class RedDeAguaPotable {
	private ArbolGeneral<String> red;
	
	public RedDeAguaPotable(ArbolGeneral<String> red) {
		this.red = red;
	}
	
	public double minimoCaudal(double caudal) {
		return minimoCaudal(caudal,this.red);
	}
	private double minimoCaudal(double caudal, ArbolGeneral<String> r) {
		if(r.esHoja()) {
			return caudal;
		}
		ListaGenerica<ArbolGeneral<String>> hijos = r.getHijos();
		double min = caudal;
		hijos.comenzar();
		while(!hijos.fin()) {
			min = Math.min(minimoCaudal(caudal/hijos.tamanio(), hijos.proximo()), min);
		}
		return min;
	}
}
