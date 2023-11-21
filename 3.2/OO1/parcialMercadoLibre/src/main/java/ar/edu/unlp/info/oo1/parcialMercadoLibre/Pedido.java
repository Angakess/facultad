package ar.edu.unlp.info.oo1.parcialMercadoLibre;

public class Pedido {
	private int cant;
	private Cliente cli;
	private Producto prodDeseado;
	private Pago metodoPago;
	private Envio tipoEnvio;
	
	public Pedido(int cant, Cliente cli, Producto pd, Pago mp, Envio te) {
		this.cant = cant;
		this.cli = cli;
		this.prodDeseado = pd;
		this.metodoPago = mp;
		this.tipoEnvio = te;
	}
	
	public boolean registrarPedido() {
		if(prodDeseado.hayStock(this.cant)) {
			return true;
		}
		return false;
	}
	
	public double getCosto() {
		return (this.getPrecioFinal() + this.getCostoEnvio());
	}
	
	
	private double getPrecioFinal() {
		return (metodoPago.calcularPago(this.getPrecioTotal()));
	}
	
	private double getCostoEnvio() {
		return tipoEnvio.getExtra();
	}
	
	private double getPrecioTotal() {
		return this.prodDeseado.getPrecioTotal(cant);
	}
}
