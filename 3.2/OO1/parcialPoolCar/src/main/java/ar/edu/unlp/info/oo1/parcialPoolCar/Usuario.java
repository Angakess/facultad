package ar.edu.unlp.info.oo1.parcialPoolCar;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

public abstract class Usuario {
	private String nombre;
	private double saldo;
	private List<Viaje> viajes;
	
	public Usuario(String nombre, double saldo) {
		this.nombre = nombre;
		this.saldo = saldo;
		this.viajes = new ArrayList<Viaje>();
	}
	
	public double getSaldo() {
		return this.saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	public List<Viaje> getViajes(){
		return this.viajes;
	}
	
	public abstract void cargarSaldo(double monto);
	
	public abstract void descontarSaldo(double monto);
}
