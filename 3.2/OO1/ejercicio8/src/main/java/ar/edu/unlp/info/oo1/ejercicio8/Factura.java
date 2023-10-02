package ar.edu.unlp.info.oo1.ejercicio8;

import java.time.LocalDate;

public class Factura {
	private double montoEnergiaActiva;
	private double descuento;
	private LocalDate fecha;
	private Usuario usuario;
	
	public Factura(double montoEnergiaActiva, double descuento, Usuario usuario) {
		this.montoEnergiaActiva = montoEnergiaActiva;
		this.descuento = descuento;
		this.usuario = usuario;
		this.fecha = LocalDate.now();
	}
	
	public double montoTotal() {
		double descuentoPorcentaje = this.descuento / 100;
		double descuentoMonto = this.montoEnergiaActiva * descuentoPorcentaje;
		
		return (this.montoEnergiaActiva - descuentoMonto);
	}
	
	/*
	public Usuario usuario() {
		return this.usuario;
	}
	
	public LocalDate fecha() {
		return this.fecha;
	}
	
	public double descuento() {
		return this.descuento;
	}

	*/
	
	public double getMontoEnergiaActiva() {
		return montoEnergiaActiva;
	}

	public double getDescuento() {
		return descuento;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public Usuario getUsuario() {
		return usuario;
	}
	
	
}
