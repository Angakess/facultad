package ar.edu.unlp.info.oo2.ejercicio2;

public class Lagarto extends Jugada{

	public Lagarto() {
		this.nombre = "Lagarto";
	}
	public boolean contraPiedra() {
		return false;
	}
	public boolean contraPapel() {
		return true;
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
