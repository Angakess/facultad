package EJ02;

public class Arreglo {

	public static int[] crearArreglo(int n) {
		int[] a = new int[n];
		for(int i = 0; i < n; i++) {
			a[i] = (i+1) * n;
		}
		return a;
	}
}
