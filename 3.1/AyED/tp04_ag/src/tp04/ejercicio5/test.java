package tp04.ejercicio5;

import tp04.ejercicio1.ArbolGeneral;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArbolGeneral<Integer> a1 = new ArbolGeneral<Integer>(10);
		ArbolGeneral<Integer> a2 = new ArbolGeneral<Integer>(5);
		ArbolGeneral<Integer> a3 = new ArbolGeneral<Integer>(20);
		ArbolGeneral<Integer> a4 = new ArbolGeneral<Integer>(9);
		ArbolGeneral<Integer> a5 = new ArbolGeneral<Integer>(7);
		ArbolGeneral<Integer> a6 = new ArbolGeneral<Integer>(4);
		ArbolGeneral<Integer> a7 = new ArbolGeneral<Integer>(2);
		ArbolGeneral<Integer> a8 = new ArbolGeneral<Integer>(3);
		ArbolGeneral<Integer> a9 = new ArbolGeneral<Integer>(1);
		ArbolGeneral<Integer> a10 = new ArbolGeneral<Integer>(30);
		
		a2.agregarHijo(a5);	a2.agregarHijo(a6);
		a3.agregarHijo(a7);
		a4.agregarHijo(a8); a4.agregarHijo(a9); a4.agregarHijo(a10);
		a1.agregarHijo(a2); a1.agregarHijo(a3); a1.agregarHijo(a4);
		
		AnalizadorArbol t = new AnalizadorArbol();
		System.out.println("Promedio de nivel maximo: "+ t.devolverMaximoPromedio(a1));
		
		if(a1.esAncestro(10, 9)) {
			System.out.println("Es ancestro");
		}
		else {
			System.out.println("No es ancestro");
		}
	}
	
	

}
