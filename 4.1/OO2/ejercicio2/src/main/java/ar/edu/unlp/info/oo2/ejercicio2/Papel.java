package ar.edu.unlp.info.oo2.ejercicio2;

public class Papel extends Jugada{
	public Papel() {
		this.nombre = "Papel";
	}
	public boolean contraPiedra() {
		return true;
	}
	public boolean contraPapel() {
		return false;
	}
	public boolean contraTijera() {
		return false;
	}
	public boolean contraLagarto() {
		return false;
	}
	public boolean contraSpock() {
		return true;
	}
}
