package ar.edu.unlp.info.oo2.ejercicio2;

public class Spock extends Jugada{

	public Spock() {
		this.nombre = "Spock";
	}
	public boolean contraPiedra() {
		return true;
	}
	public boolean contraPapel() {
		return false;
	}
	public boolean contraTijera() {
		return true;
	}
	public boolean contraLagarto() {
		return false;
	}
	public boolean contraSpock() {
		return false;
	}
}
