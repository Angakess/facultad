package ar.edu.unlp.info.oo1.parcialRecaudacion;

public class Inmueble implements Bien{
	private int nPartida;
	private double vLote;
	private double vEdif;
	
	public Inmueble(int nPartida, double vLote, double vEdif) {
		this.nPartida = nPartida;
		this.vLote = vLote;
		this.vEdif = vEdif;
	}
	
	public double getImpuesto() {
		return (this.getValor() * 0.01);
	}
	
	private double getValor() {
		return (this.vLote + this.vEdif);
	}
}
