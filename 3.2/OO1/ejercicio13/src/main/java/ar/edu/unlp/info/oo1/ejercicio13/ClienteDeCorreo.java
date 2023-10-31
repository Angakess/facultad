package ar.edu.unlp.info.oo1.ejercicio13;

import java.util.List;
import java.util.ArrayList;

public class ClienteDeCorreo {
	private Carpeta inbox;
	private List<Carpeta> carpetas;
	
	public void recibir(Email email) {
		inbox.agregarEmail(email);
	}
	public void mover(Email email, Carpeta origen, Carpeta destino) {
		origen.sacarEmail(email);
		destino.agregarEmail(email);
	}
	public Email buscar(String texto) {
		return carpetas.stream()
				.map(c -> c.buscarEmail(texto))
				.findFirst()
				.orElse(null);
	}
	
	public int espacioOcupado() {
		return inbox.tamanio() + carpetas.stream()
									.mapToInt(c -> c.tamanio())
									.sum();
	}
}
