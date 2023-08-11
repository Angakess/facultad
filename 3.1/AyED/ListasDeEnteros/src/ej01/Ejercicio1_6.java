package ej01;

import tp02.ejercicio1.*;

public class Ejercicio1_6 {
	private ListaDeEnterosEnlazada lLinked = new ListaDeEnterosEnlazada();
	
	public ListaDeEnterosEnlazada calcularSucesion(int n) {
		this.lLinked.agregarFinal(n);
		if(n != 1) {
			if(n % 2 == 0) {
				calcularSucesion(n/2);
			}
			else {
				calcularSucesion(3*n + 1);
			}
		}
		return(this.lLinked);
	}
	
	public static void main (String[] args) {
		 Ejercicio1_6 f = new Ejercicio1_6();
		 ListaDeEnterosEnlazada l = f.calcularSucesion(6);
		 //código que recorre e imprime los valores de l
		 l.comenzar();
		 while(!l.fin()) {
			 System.out.println(l.proximo());
		 }
	}
}

