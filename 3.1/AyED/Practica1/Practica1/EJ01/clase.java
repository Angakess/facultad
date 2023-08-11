package EJ01;

public class clase {
	
	public static void metodoFOR(int a, int b) {
		for( ;a <= b; a++) {
			System.out.println(a);
		}
	}
	
	public static void metodoWHILE(int a, int b) {
		while(a <= b){
			System.out.println(a);
			a++;
		}
	}
	
	public static void metodoRECURSIVO(int a, int b) {
		if(a != b) {
			System.out.println(a);
			metodoRECURSIVO(a + 1, b);
		}
		else {
			System.out.println(a);
		}
	}
}
