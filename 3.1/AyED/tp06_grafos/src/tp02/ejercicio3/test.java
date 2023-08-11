package tp02.ejercicio3;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ColaGenerica<Integer> cola = new ColaGenerica<Integer>();
		PilaGenerica<Integer> pila = new PilaGenerica<Integer>();
		
		
		cola.encolar(5);
		cola.encolar(3);
		cola.encolar(2);
		
		pila.apilar(8);
		pila.apilar(6);
		pila.apilar(4);
		
		System.out.println("Tope: " + cola.tope());
		
		cola.desencolar();
		
		System.out.println("Tope: " + cola.tope());
		
		System.out.println("Tope pila: "+ pila.tope());
		
		pila.desapilar();
		
		System.out.println("Tope pila: "+ pila.tope());
	}

}
