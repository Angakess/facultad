package Parcial2023T1;

import tp02.ejercicio2.*;
import tp02.ejercicio3.*;
import tp03.ejercicio1.*;
import tp04.ejercicio1.*;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArbolBinario<Integer> a1 = new ArbolBinario<Integer>(2);
		ArbolBinario<Integer> a2 = new ArbolBinario<Integer>(7);
		ArbolBinario<Integer> a3 = new ArbolBinario<Integer>(-5);
		ArbolBinario<Integer> a4 = new ArbolBinario<Integer>(23);
		ArbolBinario<Integer> a5 = new ArbolBinario<Integer>(6);
		ArbolBinario<Integer> a6 = new ArbolBinario<Integer>(19);
		ArbolBinario<Integer> a7 = new ArbolBinario<Integer>(-3);
		ArbolBinario<Integer> a8 = new ArbolBinario<Integer>(55);
		ArbolBinario<Integer> a9 = new ArbolBinario<Integer>(11);
		ArbolBinario<Integer> a10 = new ArbolBinario<Integer>(4);
		ArbolBinario<Integer> a11 = new ArbolBinario<Integer>(18);
		
		a1.agregarHijoIzquierdo(a2); a1.agregarHijoDerecho(a3);
		a2.agregarHijoIzquierdo(a4); a2.agregarHijoDerecho(a5);
		a3.agregarHijoIzquierdo(a6);
		a4.agregarHijoIzquierdo(a7);
		a5.agregarHijoIzquierdo(a8); a5.agregarHijoDerecho(a9);
		a6.agregarHijoDerecho(a10);
		a10.agregarHijoIzquierdo(a11);
		
		ParcialArboles pa = new ParcialArboles(a1);
		
		if(pa.isLeftTree(-5)) {
			System.out.println("cumple");
		}
		else {
			System.out.println("no cumple");
		}
	}

}
