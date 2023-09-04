package ar.edu.unlp.info.oo1.ejercicio2;

public class Producto {
	private double peso;
	private double precioPorKilo;
	private String descripcion;
	
	public double getPrecio() {
		return(this.peso * this.precioPorKilo);
	}
	
	public double getPeso() {
		return this.peso;
	}
	
	public String getDescripcion() {
		return this.descripcion;
	}
	
	public double getPrecioPorKilo() {
		return this.precioPorKilo;
	}
	
	public void setPeso(double peso) {
		this.peso = peso;
	}
	public void setPrecioPorKilo(double precio) {
		this.precioPorKilo = precio;
	}
	public void setDescripcion(String desc) {
		this.descripcion = desc;
	}
	
}
