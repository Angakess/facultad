package ar.edu.unlp.info.oo1.parcialRecaudacion;

import java.time.LocalDate;

public class Automotor extends Vehiculo{
	private String marca;
	private String modelo;
	
	public Automotor(String patente, LocalDate fFabr, double valor, String marca, String modelo) {
		super(patente, fFabr, valor);
		this.marca = marca;
		this.modelo = modelo;
	}
	
	public double getPorcentaje() {
		return 0.05;
	}
}
