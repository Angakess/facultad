package ar.edu.unlp.info.oo1.ejercicio13;

import java.util.List;
import java.util.ArrayList;

public class Email {
	private String titulo;
	private String cuerpo;
	private List<Archivo> adjuntos;
	
	public String getTitulo() {
		return titulo;
	}
	public String getCuerpo() {
		return cuerpo;
	}
	public List<Archivo> adjuntos(){
		List<Archivo> aux = new ArrayList<Archivo>();
		aux = this.adjuntos;
		return aux;
	}
	public int tamanio() {
		return (titulo.length() + cuerpo.length() +
				adjuntos.stream()
				.mapToInt(a -> a.tamanio())
				.sum());
	}
	public void adjuntar(Archivo archivo) {
		adjuntos.add(archivo);
	}
	
}
