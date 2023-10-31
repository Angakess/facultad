package ar.edu.unlp.info.oo1.ejercicio13;

import java.util.List;
import java.util.ArrayList;

public class Carpeta {
	private String nombre;
	private List<Email> emails;
	
	public String getNombre() {
		return nombre;
	}
	public void agregarEmail(Email email) {
		emails.add(email);
	}
	public Email buscarEmail(String texto) {
		return emails.stream()
		.filter(email -> email.getTitulo().equals(texto) || email.getCuerpo().equals(texto))
		.findFirst()
		.orElse(null);
	}
	public void sacarEmail(Email email) {
		emails.remove(email);
	}
	
	public int tamanio() {
		return emails.stream()
				.mapToInt(email -> email.tamanio())
				.sum();
	}
}
