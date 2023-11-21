package ar.edu.unlp.info.oo1.parcialRecaudacion;

import java.time.LocalDate;

public class Embarcacion extends Vehiculo{
	private String nombre;
	
	public Embarcacion(String patente, LocalDate fFabr, double valor, String nombre) {
		super(patente, fFabr, valor);
		this.nombre = nombre;
	}
	
	public double getPorcentaje() {
		if(this.valor < 1000000) {			//valor es 'protected', se podria hacer con un getter
			return 0.1;
		}
		return 0.15;
	}
}
