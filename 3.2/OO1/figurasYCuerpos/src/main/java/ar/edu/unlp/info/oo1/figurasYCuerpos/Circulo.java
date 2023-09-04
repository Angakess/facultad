package ar.edu.unlp.info.oo1.figurasYCuerpos;

public class Circulo implements cara {
	private double radio;
	private double diametro;
	
	public double getDiametro() {
		return this.diametro;
	}
	public void setDiametro(double diametro) {
		this.diametro = diametro;
		this.radio = diametro / 2;
	}
	public double getRadio() {
		return radio;
	}
	public void setRadio(double radio) {
		this.radio = radio;
		this.diametro = radio * 2;
	}
	
	public double getPerimetro() {
		return Math.PI * this.diametro;
	}
	
	public double getArea() {
		return Math.PI * Math.pow(radio, 2);
	}
}
