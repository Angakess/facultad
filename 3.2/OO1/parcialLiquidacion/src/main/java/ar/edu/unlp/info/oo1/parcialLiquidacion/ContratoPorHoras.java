package ar.edu.unlp.info.oo1.parcialLiquidacion;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class ContratoPorHoras extends Contrato{
	private int cantHoras;
	private double valorHora;
	private LocalDate fFin;
	
	public ContratoPorHoras(LocalDate fInicio, Empleado empleado, int cantHoras, double valorHora, LocalDate fFin) {
		super(fInicio, empleado);
		this.cantHoras = cantHoras;
		this.valorHora = valorHora;
		this.fFin = fFin;
	}
	
	public long getDuracion() {
		return (ChronoUnit.YEARS.between(this.getFInicio(), fFin));
	}
	public double calcularMonto() {
		return (this.cantHoras * this.valorHora);
	}
	public boolean estaVencido() {
		if(LocalDate.now().isBefore(fFin)) {
			return false;
		}
		return true;
	}
}
