package ar.edu.unlp.info.oo1.figurasYCuerpos;

public class Cuadrado implements cara{
	private double lado;

	public double getLado() {
		return lado;
	}
	public void setLado(double lado) {
		this.lado = lado;
	}
	
	public double getPerimetro() {
		return 4*lado;
	}
	
	public double getArea() {
		return Math.pow(lado, 2);
	}
	
}
