package ar.edu.unlp.info.oo2.ejercicio5;

public class Pasante extends Empleado{
	private int cantExamen;
	
	public Pasante(boolean casado, int hijos, int cantExam) {
		this.casado = casado;
		this.hijos = hijos;
		this.cantExamen = cantExam;
	}
	
	public double basico() {
		return 20000;
	}
	public double adicional1() {
		return (this.cantExamen * 2000);
	}
	public double adicional2() {
		return (this.cantExamen * 2000);
	}
	

}
