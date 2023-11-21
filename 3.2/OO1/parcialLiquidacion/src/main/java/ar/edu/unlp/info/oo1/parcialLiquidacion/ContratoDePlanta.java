package ar.edu.unlp.info.oo1.parcialLiquidacion;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class ContratoDePlanta extends Contrato{
	private double sueldo;
	
	public ContratoDePlanta(LocalDate fInicio, Empleado empleado, double sueldo) {
		super(fInicio, empleado);
		this.sueldo = sueldo;
	}
	
	public long getDuracion() {
		LocalDate fActual = LocalDate.now();
		return (ChronoUnit.YEARS.between(this.getFInicio(), fActual));
	}
	public double calcularMonto() {
		double monto = this.sueldo;
		if(this.getEmpleado().getTieneConyugue()) {
			monto += 100;
		}
		if(this.getEmpleado().getTieneHijos()) {
			monto += 300;
		}
		return monto;
	}
	public boolean estaVencido() {
		return false;
	}
}
