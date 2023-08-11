package ParcialEjerc2;

import tp02.ejercicio2.*;
import tp02.ejercicio3.*;
import tp03.ejercicio1.*;

public class Parcial2 {

	public static Integer sumaImparesPosOrderMayorA(ArbolBinario<Integer> ab, int limite) {
		int total = 0;
		if(!ab.esVacio()) {
			if(ab.tieneHijoIzquierdo()) {
				total += sumaImparesPosOrderMayorA(ab.getHijoIzquierdo(), limite);
			}
			if(ab.tieneHijoDerecho()) {
				total += sumaImparesPosOrderMayorA(ab.getHijoDerecho(), limite);
			}
			if(((ab.getDato()%2) != 0)&&(ab.getDato() > limite)) {
				total += ab.getDato();
			}
			return total;
		}
		return -1;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArbolBinario<Integer> a1 = new ArbolBinario<Integer>(7);
		ArbolBinario<Integer> a2 = new ArbolBinario<Integer>(56);
		ArbolBinario<Integer> a3 = new ArbolBinario<Integer>(25);
		ArbolBinario<Integer> a4 = new ArbolBinario<Integer>(38);
		ArbolBinario<Integer> a5 = new ArbolBinario<Integer>(31);
		ArbolBinario<Integer> a6 = new ArbolBinario<Integer>(5);
		ArbolBinario<Integer> a7 = new ArbolBinario<Integer>(6);
		ArbolBinario<Integer> a8 = new ArbolBinario<Integer>(87);
		ArbolBinario<Integer> a9 = new ArbolBinario<Integer>(77);
		ArbolBinario<Integer> a10 = new ArbolBinario<Integer>(94);
		ArbolBinario<Integer> a11 = new ArbolBinario<Integer>(16);
		ArbolBinario<Integer> a12 = new ArbolBinario<Integer>(2);
		ArbolBinario<Integer> a13 = new ArbolBinario<Integer>(43);
		ArbolBinario<Integer> a14 = new ArbolBinario<Integer>(1);
		ArbolBinario<Integer> a15 = new ArbolBinario<Integer>(9);
		ArbolBinario<Integer> a16 = new ArbolBinario<Integer>(10);
		
		a1.agregarHijoIzquierdo(a2); a1.agregarHijoDerecho(a3);
		a2.agregarHijoIzquierdo(a4); a2.agregarHijoDerecho(a5);
		a3.agregarHijoIzquierdo(a6); a3.agregarHijoDerecho(a7);
		a4.agregarHijoIzquierdo(a8); a4.agregarHijoDerecho(a9);
		a5.agregarHijoDerecho(a10);
		a9.agregarHijoIzquierdo(a11);
		a10.agregarHijoDerecho(a12);
		a11.agregarHijoDerecho(a13);
		a12.agregarHijoIzquierdo(a14);
		a13.agregarHijoIzquierdo(a15); a13.agregarHijoDerecho(a16);
		
		System.out.println("Total: "+ Parcial2.sumaImparesPosOrderMayorA(a1, 30));
	}

}
