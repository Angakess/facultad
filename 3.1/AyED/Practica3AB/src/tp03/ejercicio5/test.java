package tp03.ejercicio5;

import tp03.ejercicio1.ArbolBinario;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArbolBinario<Integer> a = new ArbolBinario<Integer>(20);
		
		a.agregarHijoIzquierdo(new ArbolBinario<Integer>(30));
		a.agregarHijoDerecho(new ArbolBinario<Integer>(40));
		a.getHijoIzquierdo().agregarHijoIzquierdo(new ArbolBinario<Integer>(15));
		a.getHijoIzquierdo().agregarHijoDerecho(new ArbolBinario<Integer>(25));
		a.getHijoDerecho().agregarHijoIzquierdo(new ArbolBinario<Integer>(5));
		a.getHijoDerecho().agregarHijoDerecho(new ArbolBinario<Integer>(10));
		
		ProfundidadDeArbolBinario p = new ProfundidadDeArbolBinario(a);
		
		System.out.println(p.sumaElementosProfundidad(2));
	}

}
