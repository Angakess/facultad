package ar.edu.unlp.info.oo1.parcialPoolCar;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.ArrayList;

public class Vehiculo {
	private String desc;
	private int cap;
	private LocalDate anio;
	private double valor;
	private Conductor duenio;
	
	public Vehiculo(String desc, int cap, LocalDate anio, double valor, Conductor duenio) {
		this.desc = desc;
		this.cap = cap;
		this.anio = anio;
		this.valor = valor;
		this.duenio = duenio;
	}
	
	public Conductor getDuenio() {
		return this.duenio;
	}
	
	public boolean autoEsViejo() {
		if(ChronoUnit.YEARS.between(anio, LocalDate.now()) >= 5) {
			return true;
		}
		return false;
	}
	
	public double calcularBonus() {
		return this.valor * 0.001;
	}
	
	public boolean hayLugar(int cantActual) {
		if(cantActual < this.cap) {
			return true;
		}
		return false;
	}
}
