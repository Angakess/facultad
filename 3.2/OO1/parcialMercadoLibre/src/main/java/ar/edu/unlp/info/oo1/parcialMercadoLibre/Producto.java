package ar.edu.unlp.info.oo1.parcialMercadoLibre;

public class Producto {
	private String nombre;
	private String desc;
	private double precio;
	private int stk;
	
	public Producto(String nombre, String desc, double precio, int stk) {
		this.nombre = nombre;
		this.desc = desc;
		this.precio = precio;
		this.stk = stk;
	}
	
	public boolean hayStock(int cant) {
		if(this.stk >= cant) {
			this.actualizarStock(cant);
			return true;
		}
		return false;
	}
	private void actualizarStock(int cant) {
		this.stk -= cant;
	}
	
	public double getPrecio() {
		return this.precio;
	}
	
	public double getPrecioTotal(int cant) {
		return this.precio * cant;
	}
	
	public String getNombre() {
		return this.nombre;
	}
}
