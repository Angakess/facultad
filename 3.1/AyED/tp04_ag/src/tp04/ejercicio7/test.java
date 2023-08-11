package tp04.ejercicio7;

import tp04.ejercicio1.*;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArbolGeneral<String> A = new ArbolGeneral<String>("A");
		ArbolGeneral<String> B = new ArbolGeneral<String>("B");
		ArbolGeneral<String> C = new ArbolGeneral<String>("C");
		ArbolGeneral<String> D = new ArbolGeneral<String>("D");
		ArbolGeneral<String> E = new ArbolGeneral<String>("E");
		ArbolGeneral<String> F = new ArbolGeneral<String>("F");
		ArbolGeneral<String> G = new ArbolGeneral<String>("G");
		ArbolGeneral<String> H = new ArbolGeneral<String>("H");
		ArbolGeneral<String> I = new ArbolGeneral<String>("I");
		ArbolGeneral<String> J = new ArbolGeneral<String>("J");
		ArbolGeneral<String> K = new ArbolGeneral<String>("K");
		ArbolGeneral<String> L = new ArbolGeneral<String>("L");
		ArbolGeneral<String> M = new ArbolGeneral<String>("M");
		ArbolGeneral<String> N = new ArbolGeneral<String>("N");
		
		ArbolGeneral<String> Z = new ArbolGeneral<String>("Z");
		
		A.agregarHijo(B); 
		A.agregarHijo(C); 
		A.agregarHijo(D); 
		A.agregarHijo(E);
		
		C.agregarHijo(F); 
		C.agregarHijo(G);
		
		D.agregarHijo(H); 
		D.agregarHijo(I); 
		D.agregarHijo(J); 
		D.agregarHijo(K);
		D.agregarHijo(Z);
		
		G.agregarHijo(L);
		
		J.agregarHijo(M); 
		J.agregarHijo(N);
		
		RedDeAguaPotable red = new RedDeAguaPotable(A);
		
		System.out.println(red.minimoCaudal(1000));
		
	}

}
