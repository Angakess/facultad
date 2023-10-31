package ar.edu.unlp.info.oo1.ejercicio11;

import java.util.ArrayList;
import java.util.List;

public class Inversor {
	private String nombre;
	private List<Inversion> inversiones;
	
	public Inversor(String nombre) {
		this.nombre = nombre;
		this.inversiones = new ArrayList<Inversion>();
	}
	
	public void agregarInversion(Inversion inv) {
		inversiones.add(inv);
	}
	
	
	public double valorActual() {
		double total = 0;
		
		total += inversiones.stream()
		.mapToDouble(inv -> inv.valorActual())
		.sum();
		
		return total;
	}
}
