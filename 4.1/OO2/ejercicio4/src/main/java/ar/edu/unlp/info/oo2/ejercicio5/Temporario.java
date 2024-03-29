package ar.edu.unlp.info.oo2.ejercicio5;

public class Temporario extends Empleado{
	private int horas;
	
	public Temporario(boolean casado, int hijos, int horas) {
		this.casado = casado;
		this.hijos = hijos;
		this.horas = horas;
	}
	
	public double basico() {
		return (20000 + this.horas * 300);
	}
	
	public double adicional1() {
		double total = 0;
		if(this.casado) {
			total = total + 5000; 
		}
		total = total + (this.hijos * 2000);
		return total;
	}
	
	//se puede (debe?) sacar si es la version adicional2
	
	

}
