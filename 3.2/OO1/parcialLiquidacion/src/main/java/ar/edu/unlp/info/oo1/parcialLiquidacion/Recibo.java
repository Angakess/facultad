package ar.edu.unlp.info.oo1.parcialLiquidacion;

import java.time.LocalDate;

public class Recibo {
	private String nombre;
	private String apellido;
	private int cuil;
	private double antiguedad;
	private LocalDate fRecibo;
	private double monto;
	
	public Recibo(String nombre, String apellido, int cuil, double antiguedad, double monto) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.cuil = cuil;
		this.antiguedad = antiguedad;
		this.fRecibo = LocalDate.now();
		this.monto = monto;
	}
	
	
}
