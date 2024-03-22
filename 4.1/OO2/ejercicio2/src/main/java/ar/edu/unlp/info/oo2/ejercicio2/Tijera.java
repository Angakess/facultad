package ar.edu.unlp.info.oo2.ejercicio2;

public class Tijera extends Jugada{

	public Tijera() {
		this.nombre = "Tijera";
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
		return true;
	}
	public boolean contraSpock() {
		return false;
	}

}
