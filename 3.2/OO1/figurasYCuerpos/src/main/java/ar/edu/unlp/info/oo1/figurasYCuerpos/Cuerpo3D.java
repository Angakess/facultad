package ar.edu.unlp.info.oo1.figurasYCuerpos;

public class Cuerpo3D {
	private double altura;
	private cara caraBasal;
	
	public double getAltura() {
		return altura;
	}
	public void setAltura(double altura) {
		this.altura = altura;
	}
	public void setCaraBasal(cara caraBasal) {
		this.caraBasal = caraBasal;
	}
	
	public double getSuperficieExterior() {
		return 2 * this.caraBasal.getArea() + this.caraBasal.getPerimetro() * this.altura;
	}
	
	public double getVolumen() {
		return this.caraBasal.getArea() * this.altura;
	}
	
}
