package ar.edu.unlp.info.oo1.ejercicio11;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit; 

public class PlazoFijo implements Inversion{
	private LocalDate fechaDeConstitucion;
	private double montoDepositado;
	private double porcentajeDeInteresDiario;
	
	public PlazoFijo(double montoDepositado, double porcentajeDeInteresDiario) {
		this.fechaDeConstitucion = LocalDate.now();
		this.montoDepositado = montoDepositado;
		this.porcentajeDeInteresDiario = porcentajeDeInteresDiario;
	}
	public PlazoFijo(LocalDate fecha, double montoDepositado, double porcentajeDeInteresDiario) {
		this.fechaDeConstitucion = fecha;
		this.montoDepositado = montoDepositado;
		this.porcentajeDeInteresDiario = porcentajeDeInteresDiario;
	}
	
	public double valorActual() {
		long cantDias = ChronoUnit.DAYS.between(this.fechaDeConstitucion, LocalDate.now());
		return (montoDepositado + (montoDepositado * porcentajeDeInteresDiario * cantDias));
	}
}
