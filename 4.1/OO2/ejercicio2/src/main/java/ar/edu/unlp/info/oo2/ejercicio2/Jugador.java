package ar.edu.unlp.info.oo2.ejercicio2;

public class Jugador {
	private Jugada jugada;
	public Jugador() {
		this.jugada = null;
	}
	
	public Jugada getJugada() {
		return this.jugada;
	}
	
	public void tirarPiedra() {
		this.jugada = new Piedra();
	}
	public void tirarPapel() {
		this.jugada = new Papel();
	}
	public void tirarTijera() {
		this.jugada = new Tijera();
	}
	public void tirarLagarto() {
		this.jugada = new Lagarto();
	}
	public void tirarSpock() {
		this.jugada = new Spock();
	}
}
