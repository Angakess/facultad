package ar.edu.unlp.info.oo1.ejercicio2;

import java.util.List;
import java.util.ArrayList;

public class Balanza {
	private int cantidadDeProductos;
	//3bis
//	private double precioTotal;
//	private double pesoTotal;
	
	private List<Producto> productos;
	
	//3bis
	public Balanza() {
		this.productos = new ArrayList<Producto>();
	}
	
	public void ponerEnCero() {
		this.cantidadDeProductos = 0;
//		this.pesoTotal = 0;
//		this.precioTotal = 0;
		
		//3bis
		this.productos.clear();
	}
	
	public void agregarProducto(Producto producto) {
		this.cantidadDeProductos++;
//		this.pesoTotal += producto.getPeso();
//		this.precioTotal += producto.getPrecio();
		
		//3bis
		this.productos.add(producto);
	}
	
	public Ticket emitirTicket() {
		return (new Ticket(this.cantidadDeProductos, this.getPesoTotal(), this.getPrecioTotal(), this.productos));
	}
	
	public double getPesoTotal() {
		//3bis
		//return this.pesoTotal;
		
		double total = 0;
		for(Producto producto : this.productos) {
			total += producto.getPeso();
		}
		return total;
	}
	public double getPrecioTotal() {
		//3bis
		//return this.precioTotal;
		
		double total = 0;
		for(Producto producto : this.productos) {
			total += producto.getPrecio();
		}
		return total;
	}
	public int getCantidadDeProductos() {
		return this.cantidadDeProductos;
	}
	
	//3bis
	public List<Producto> getProductos() {
		return this.productos;
	}
}
