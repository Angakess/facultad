package ar.edu.unlp.info.oo1.ejercicio8;

import java.lang.Math;
import java.time.LocalDate;

public class Consumo {
	private LocalDate fecha;
	private double consumoEnergiaActiva;
	private double consumoEnergiaReactiva;
	
	public Consumo(LocalDate fecha, double consumoEnergiaActiva, double consumoEnergiaReactiva) {
		this.fecha = fecha;
		this.consumoEnergiaActiva = consumoEnergiaActiva;
		this.consumoEnergiaReactiva = consumoEnergiaReactiva;
	}
	
	public double costoEnBaseA(double precioKWh) {
		return (consumoEnergiaActiva * precioKWh);
	}
	
	public double factorDePotencia() {
		double consumoEnergiaActivaSquared = Math.pow(consumoEnergiaActiva, 2);
		double consumoEnergiaReactivaSquared = Math.pow(consumoEnergiaReactiva, 2);
		double consumoEnergiaRoot = Math.sqrt(consumoEnergiaActivaSquared + consumoEnergiaReactivaSquared);
		
		return (consumoEnergiaActiva/consumoEnergiaRoot);
	}
	
	public double getConsumoEnergiaActiva() {
		return this.consumoEnergiaActiva;
	}
	
	public LocalDate getFecha() {
		return this.fecha;
	}
}
