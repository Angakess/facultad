package ar.edu.unlp.info.oo1.ejercicio12;

import java.util.List;
import java.util.ArrayList;

public class ReporteDeConstruccion {
	private List<Pieza> piezas;
	
	public ReporteDeConstruccion() {
		this.piezas = new ArrayList<Pieza>();
	}
	
	public void agregarPieza(Pieza pieza) {
		piezas.add(pieza);
	}
	public double getVolumenDeMaterial(String material) {
		int total = 0;
		total += this.piezas.stream()
				.filter(p -> p.getMaterial().equals(material))
				.mapToDouble(p -> p.getVolumen())
				.sum();
		return total;
	}
	public double getSuperficieDeColor(String color) {
		int total = 0;
		total += this.piezas.stream()
				.filter(p -> p.getColor().equals(color))
				.mapToDouble(p -> p.getSuperficie())
				.sum();
		return total;
	}
}
