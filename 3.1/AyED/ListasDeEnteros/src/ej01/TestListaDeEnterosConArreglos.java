package ej01;

import tp02.ejercicio1.*;

public class TestListaDeEnterosConArreglos {

	public static void imprimirInverso(ListaDeEnterosConArreglos lA) {
		int num = -1;
		if(!lA.fin()) {
			num = lA.proximo();
			imprimirInverso(lA);
		}
		if(num != -1) {
			System.out.println(num);
		}
	}	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListaDeEnterosConArreglos lArray = new ListaDeEnterosConArreglos();
		
		for(int i = 0; i<5; i++) {
			lArray.agregarFinal(i);
		}
		
		lArray.comenzar();
		while(!lArray.fin()) {
			System.out.println(lArray.proximo());
		}
		
		lArray.comenzar();
		imprimirInverso(lArray);
		
	}

}