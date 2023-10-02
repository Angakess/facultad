package ar.edu.unlp.info.oo1.ejercicio8;

import java.util.List;
import java.util.ArrayList;

public class Distribuidora {
	private double precioKWh;
	private List<Usuario> usuarios;
	
	public Distribuidora(double precioKWh) {
		this.precioKWh = precioKWh;
		this.usuarios = new ArrayList<Usuario>();
	}
	
	public void agregarUsuario(Usuario usuario) {
		this.usuarios.add(usuario);
	}
	
	public List<Factura> facturar() {		//Ni idea que pide
		List<Factura> lista = new ArrayList<Factura>();
		for(Usuario u : this.usuarios) {
			lista.add(u.facturarEnBaseA(precioKWh));
		}
		return lista;
	}
	
	public double consumoTotalActiva() {
		int total = 0;
		for(Usuario u : this.usuarios) {
			total += u.ultimoConsumoActiva();
		}
		return total;
	}
	
	// Setter ???
	public void precioKWh(double precio) {
		this.precioKWh = precio;
	}
	
	
	public List<Usuario> getUsuarios(){
		return this.usuarios;
	}
	
	public double getPrecioKW() {
		return precioKWh;
	}
}
