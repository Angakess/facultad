package tp02.ejercicio4;

import tp02.ejercicio3.*;
import tp02.ejercicio2.*;

public class TestBalanceo {
	private static PilaGenerica<Character> pila = new PilaGenerica<Character>();
	
	public static boolean esBalanceado(String s) {
		boolean aux = true;
		for (int i = 0; i < s.length(); i++) {
			if((s.charAt(i) == '(')||(s.charAt(i) == '{')||(s.charAt(i) == '[')) {
				pila.apilar(s.charAt(i));
			}
			if(s.charAt(i) == ')') {
				return (pila.desapilar() == '(');
			}
			else if(s.charAt(i) == '}') {
				return (pila.desapilar() == '{');
			}
			else if(s.charAt(i) == ']') {
				return (pila.desapilar() == '[');
			}
		}
		return aux;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "{( ) [ ( ) ] }";
		String s2 = "( [ ) ]" ;
		String s3 = "asd(as[as{s}])";
		String s4 = "";
		String s5 = "asdf(as[a)as]a";
		
		System.out.println("S1: "+esBalanceado(s1));
		System.out.println("S2: "+esBalanceado(s2));
		System.out.println("S3: "+esBalanceado(s3));
		System.out.println("S4: "+esBalanceado(s4));
		System.out.println("S5: "+esBalanceado(s5));
	}

}
