package ar.edu.unlp.info.oo1.parcialRecaudacion;

import java.util.List;
import java.util.ArrayList;

public class Contribuyente {
	private String nombre;
	private int dni;
	private String email;
	private String localidad;
	private List<Bien> bienes;
	
	public Contribuyente(String nombre, int dni, String email, String localidad) {
		this.nombre = nombre;
		this.dni = dni;
		this.email = email;
		this.localidad = localidad;
		this.bienes = new ArrayList<Bien>();
	}
	
	public void agregarBien(Bien b) {
		this.bienes.add(b);
	}
	
	public double calcularImpuesto() {
		return this.bienes.stream()
				.mapToDouble(bien -> bien.getImpuesto())
				.sum();
	}
	
	public String getLocalidad() {
		return this.localidad;
	}
}
