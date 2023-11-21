package ar.edu.unlp.info.oo1.parcialMercadoLibre;

public class EnvioDomicilio implements Envio{
	public double getExtra() {
		return (0.5 * this.getDist());
	}
	
	private double getDist() {
		return 100;
	}
}
