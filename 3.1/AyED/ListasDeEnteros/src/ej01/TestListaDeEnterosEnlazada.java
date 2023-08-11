package ej01;

import tp02.ejercicio1.*;

public class TestListaDeEnterosEnlazada {

	public static void imprimirInverso(ListaDeEnterosEnlazada lL) {
		int num = -1;
		if(!lL.fin()) {
			num = lL.proximo();
			imprimirInverso(lL);
		}
		if(num != -1) {
			System.out.println(num);
		}
	}	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListaDeEnterosEnlazada lLinked = new ListaDeEnterosEnlazada();
		
		for(int i = 1; i<6; i++) {
			lLinked.agregarFinal(i*2);
		}
		
		lLinked.comenzar();
		while(!lLinked.fin()) {
			System.out.println(lLinked.proximo());
		}
		
		lLinked.comenzar();
		imprimirInverso(lLinked);
		
	}
}
