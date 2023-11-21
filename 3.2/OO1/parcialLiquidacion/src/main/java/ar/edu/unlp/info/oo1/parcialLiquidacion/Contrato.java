package ar.edu.unlp.info.oo1.parcialLiquidacion;

import java.time.LocalDate;

public abstract class Contrato {
	private LocalDate fInicio;
	private Empleado empleado;

	public Contrato(LocalDate fInicio, Empleado empleado) {
		this.fInicio = fInicio;
		this.empleado = empleado;
	}
	
	public LocalDate getFInicio() {
		return this.fInicio;
	}
	public Empleado getEmpleado() {
		return this.empleado;
	}
	public abstract long getDuracion();
	public abstract double calcularMonto();
	public abstract boolean estaVencido();
}