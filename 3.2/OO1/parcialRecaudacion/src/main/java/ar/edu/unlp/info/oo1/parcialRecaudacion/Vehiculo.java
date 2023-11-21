package ar.edu.unlp.info.oo1.parcialRecaudacion;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public abstract class Vehiculo implements Bien{
	private String patente;
	private LocalDate fFabr;
	protected double valor;
	
	public Vehiculo(String patente, LocalDate fFabr, double valor) {
		this.patente = patente;
		this.fFabr = fFabr;
		this.valor = valor;
	}
	
	public double getImpuesto() {
		if(ChronoUnit.YEARS.between(fFabr, LocalDate.now()) > 10) {
			return 0;
		}
		return (this.valor * this.getPorcentaje());
	}
	
	public double getValor() {
		return this.valor;
	}
	
	public abstract double getPorcentaje();
	
	
}
