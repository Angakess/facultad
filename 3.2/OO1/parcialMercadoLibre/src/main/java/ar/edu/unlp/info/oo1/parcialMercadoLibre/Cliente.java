package ar.edu.unlp.info.oo1.parcialMercadoLibre;

public class Cliente {
	private String nombre;
	private String dir;
	
	public Cliente(String nombre, String dir) {
		this.nombre = nombre;
		this.dir = dir;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	public String getDir() {
		return this.dir;
	}
}
