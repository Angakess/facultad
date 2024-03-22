package ar.edu.unlp.info.oo2.ejercicio2;

public class Piedra extends Jugada{
	public Piedra() {
		this.nombre = "Piedra";
	}
	public boolean contraPiedra() {
		return false;
	}
	public boolean contraPapel() {
		return false;
	}
	public boolean contraTijera() {
		return true;
	}
	public boolean contraLagarto() {
		return true;
	}
	public boolean contraSpock() {
		return false;
	}
}
