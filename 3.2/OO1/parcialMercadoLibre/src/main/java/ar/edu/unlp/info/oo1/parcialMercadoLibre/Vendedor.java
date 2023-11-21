package ar.edu.unlp.info.oo1.parcialMercadoLibre;

import java.util.List;
import java.util.stream.Collectors;
import java.util.ArrayList;

public class Vendedor {
	private String nombre;
	private String dir;
	private List<Producto> productos;
	
	public Vendedor(String nombre, String dir) {
		this.nombre = nombre;
		this.dir = dir;
		this.productos = new ArrayList<Producto>();
	}
	
	public void agregarProducto(Producto prod) {
		this.productos.add(prod);
	}
	public List<Producto> buscarProductos(String nombre){
		return this.productos.stream()
		.filter(p -> p.getNombre().equals(nombre))
		.collect(Collectors.toList());
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public String getDir() {
		return this.dir;
	}
}
