package ar.edu.unlp.info.oo1.parcialLiquidacion;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

public class Empleado {
	private String nombre;
	private String apellido;
	private int cuil;
	private LocalDate fNac;
	private boolean tieneConyugue;
	private boolean tieneHijos;
	private LocalDate fInicio;
	private List<Contrato> contratos;
	private Recibo recibo;
	
	public Empleado(String nombre, String apellido, int cuil, LocalDate fNac, boolean tieneConyugue, boolean tieneHijos, LocalDate fInicio) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.cuil = cuil;
		this.fNac = fNac;
		this.tieneConyugue = tieneConyugue;
		this.tieneHijos = tieneHijos;
		this.fInicio = fInicio;
		this.contratos = new ArrayList<Contrato>();
		this.recibo = null;
	}
	
	public int getCuil() {
		return this.cuil;
	}
	public boolean getTieneConyugue() {
		return this.tieneConyugue;
	}
	public boolean getTieneHijos() {
		return this.tieneHijos;
	}
	public void cargarContrato(Contrato contrato) {
		if(this.contratos.stream().allMatch(c -> c.estaVencido()) || contrato.estaVencido()) {
			this.contratos.add(contrato);
		}
	}
	public Recibo calcularRecibo() {
		Contrato contratoActual = this.contratos.stream()
				.filter(c -> !(c.estaVencido()))
				.findFirst()
				.orElse(null);
		
		double antiguedad = 0;
		double montoBasico = 0;
		if(contratoActual != null) {
			contratoActual.calcularMonto();
		}
		
		double anios = this.contratos.stream()
				.mapToLong(c -> c.getDuracion())
				.sum();
		anios += contratoActual.getDuracion();
		
		if(anios >= 5 && anios < 10) {
			antiguedad = montoBasico * 0.3;
		}
		else if(anios >= 10 && anios < 15) {
			antiguedad = montoBasico * 0.5;
		}
		else if(anios >= 15 && anios < 20) {
			antiguedad = montoBasico * 0.7;
		}
		else if(anios >= 20) {
			antiguedad = montoBasico;
		}
		
		double monto = montoBasico + antiguedad;
		return this.recibo = new Recibo(this.nombre, this.apellido, this.cuil, antiguedad, monto);
	}
	
	public List<Contrato> getContratos(){
		List<Contrato> cList = new ArrayList<Contrato>();
		cList.addAll(contratos);
		return cList;
	}
}
