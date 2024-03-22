package ar.edu.unlp.info.oo2.ejercicio2;

public abstract class Jugada {
	protected String nombre;
	
	public abstract boolean contraPiedra();
	
	public abstract boolean contraPapel();
	
	public abstract boolean contraTijera();
	
	public abstract boolean contraLagarto();
	
	public abstract boolean contraSpock();
	
	public String getNombre() {
		return this.nombre;
	}
}
