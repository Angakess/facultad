package ar.edu.unlp.info.oo1.parcialPoolCar;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

public class Pasajero extends Usuario{
	public Pasajero(String nombre, double saldo) {
		super(nombre, saldo);
	}
	
	public void cargarSaldo(double monto) {
		if(!hizoViajeReciente()) {
			monto -= monto * 0.1; 
		}
		this.setSaldo(this.getSaldo() + monto);
	}
	private boolean hizoViajeReciente() {
		if(this.getViajes().stream().anyMatch(v -> v.esReciente())) {
			return true;
		}
		return false;
	}
	
	public void descontarSaldo(double monto) {
		if(hizoAlgunViaje()) {
			monto -= 500;
		}
		this.setSaldo(this.getSaldo() - monto);
	}
	private boolean hizoAlgunViaje() {
		if(!this.getViajes().isEmpty()) {
			return true;
		}
		return false;
	}
	
	public boolean estaEnRojo() {
		if(this.getSaldo() < 0) {
			return true;
		}
		return false;
	}
}
