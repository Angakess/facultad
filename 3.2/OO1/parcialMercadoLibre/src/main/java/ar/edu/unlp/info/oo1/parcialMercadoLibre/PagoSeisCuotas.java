package ar.edu.unlp.info.oo1.parcialMercadoLibre;

public class PagoSeisCuotas implements Pago{
	public double calcularPago(double p) {
		return (p * 0.2) + p;
	}
}
