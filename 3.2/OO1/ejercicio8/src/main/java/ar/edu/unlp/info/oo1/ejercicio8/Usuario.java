package ar.edu.unlp.info.oo1.ejercicio8;

import java.util.List;
import java.util.ArrayList;
import java.time.LocalDate;

public class Usuario {
	private String domicilio;
	private String nombre;
	private List<Factura> facturas;
	private List<Consumo> consumos;

	public Usuario(String domicilio, String nombre) {
		this.domicilio = domicilio;
		this.nombre = nombre;
		this.facturas = new ArrayList<Factura>();
		this.consumos = new ArrayList<Consumo>();
	}

	public void agregarMedicion(Consumo medicion) {
		this.consumos.add(medicion);
	}

	public double ultimoConsumoActiva() {
		if (this.ultimoConsumo() != null) {
			return this.ultimoConsumo().getConsumoEnergiaActiva();
		}
		return 0;
	}

	public Factura facturarEnBaseA(double precioKWh) {
		double descuento = 0;
		double montoCalculado = 0;

		if (this.ultimoConsumo() != null) {
			montoCalculado = this.ultimoConsumo().costoEnBaseA(precioKWh);
			if (this.ultimoConsumo().factorDePotencia() > 0.8) {
				descuento = 10;
			}
		}

		Factura f = new Factura(montoCalculado, descuento, this);
		this.facturas.add(f);
		return (f);
	}

	public List<Factura> facturas() {
		return this.facturas;
	}

	public Consumo ultimoConsumo() {
		LocalDate ultFecha = LocalDate.MIN;
		Consumo ultConsumo = null;
		for (Consumo c : this.consumos) {
			if (c.getFecha().compareTo(ultFecha) >= 0) {
				ultFecha = c.getFecha();
				ultConsumo = c;
			}
		}

		return ultConsumo;
	}
}
