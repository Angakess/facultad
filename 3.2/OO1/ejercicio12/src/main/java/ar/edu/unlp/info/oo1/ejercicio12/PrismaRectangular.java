package ar.edu.unlp.info.oo1.ejercicio12;

public class PrismaRectangular extends Pieza{
	private int ladoMayor;
	private int ladoMenor;
	private int altura;
	
	public PrismaRectangular(String material, String color, int ladoMayor, int ladoMenor, int altura) {
		super(material, color);
		this.ladoMayor = ladoMayor;
		this.ladoMenor = ladoMenor;
		this.altura = altura;
	}
	
	public double getVolumen() {
		return (ladoMayor * ladoMenor * altura);
	}
	public double getSuperficie() {
		return (2 * (ladoMayor * ladoMenor + ladoMayor * altura + ladoMenor * altura));
	}
}
