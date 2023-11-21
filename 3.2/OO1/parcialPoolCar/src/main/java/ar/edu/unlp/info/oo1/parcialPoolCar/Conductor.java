package ar.edu.unlp.info.oo1.parcialPoolCar;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

public class Conductor extends Usuario{
	private Vehiculo vehiculo;
	
	public Conductor(String nombre, double saldo, Vehiculo vehiculo) {
		super(nombre, saldo);
		this.vehiculo = vehiculo;
	}
	
	public void cargarSaldo(double monto) {
		if(this.vehiculo.autoEsViejo()) {
			monto -= monto * 0.01;
		}
		else {
			monto -= monto * 0.1;
		}
		this.setSaldo(this.getSaldo() + monto);
	}
	
	public void descontarSaldo(double monto) {
		monto -= this.vehiculo.calcularBonus();
		this.setSaldo(this.getSaldo() - monto);
	}
}
