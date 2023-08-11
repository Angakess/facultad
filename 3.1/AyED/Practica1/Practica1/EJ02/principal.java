package EJ02;

public class principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N = Ingresar.IngresarN();
		
		for(int i = 0; i < N; i++) {
			System.out.println(Arreglo.crearArreglo(N)[i]);
		}
	}
}
