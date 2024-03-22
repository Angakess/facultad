package ar.edu.unlp.info.oo2.ejercicio2;

public class Sistema {
	private Jugador jugadorA;
	private Jugador jugadorB;
	
	public Sistema(Jugador A, Jugador B) {
		this.jugadorA = A;
		this.jugadorB = B;
	}
	
	public Jugador ganador() {
		String jugadaA = jugadorA.getJugada().getNombre();
		
		if (jugadaA.equals("Piedra")) {
			if(jugadorB.getJugada().contraPiedra()) {
				return jugadorB;
			}
		}
		else if(jugadaA.equals("Papel")) {
			if(jugadorB.getJugada().contraPapel()) {
				return jugadorB;
			}
		}
		else if(jugadaA.equals("Tijera")) {
			if(jugadorB.getJugada().contraTijera()) {
				return jugadorB;
			}
		}
		else if(jugadaA.equals("Lagarto")) {
			if(jugadorB.getJugada().contraLagarto()) {
				return jugadorB;
		}
		else if(jugadaA.equals("Spock")) {
			if(jugadorB.getJugada().contraSpock()) {
				return jugadorB;
			}
		}
		else {
			return jugadorA;
		}
	}

}
