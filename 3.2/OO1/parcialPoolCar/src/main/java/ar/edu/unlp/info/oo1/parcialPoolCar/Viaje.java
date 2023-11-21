package ar.edu.unlp.info.oo1.parcialPoolCar;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.ArrayList;

public class Viaje {
	private String origen;
	private String destino;
	private double costo;
	private LocalDate fecha;
	private Vehiculo vehiculoViaje;
	private List<Usuario> viajeros;
	
	public Viaje(String origen, String destino, double costo, Vehiculo vehiculoViaje, LocalDate fecha) {
		this.origen = origen;
		this.destino = destino;
		this.costo = costo;
		this.vehiculoViaje = vehiculoViaje;
		this.fecha = fecha;
		this.viajeros = new ArrayList<Usuario>();
		this.viajeros.add(this.vehiculoViaje.getDuenio());
	}
	
	public boolean saleManiana() {
		if(ChronoUnit.DAYS.between(fecha, LocalDate.now()) < 2) {
			return true;
		}
		return false;
	}
	
	public boolean esReciente() {
		if(ChronoUnit.DAYS.between(fecha, LocalDate.now()) <= 30) {
			return true;
		}
		return false;
	}
	
	public void procesarViaje() {
		double costoIndividual = this.costo / this.viajeros.size();
		for(Usuario u : this.viajeros) {
			u.descontarSaldo(costoIndividual);
		}
	}
	
	public void agregarPasajero(Pasajero pasajero) {
		if(vehiculoViaje.hayLugar(this.viajeros.size()) && !pasajero.estaEnRojo() && aTiempoParaRegistrarse()) {
			this.viajeros.add(pasajero);
		}
	}
	
	private boolean aTiempoParaRegistrarse() {
		if(ChronoUnit.DAYS.between(fecha, LocalDate.now()) <= 2) {
			return true;
		}
		return false;
	}
}
