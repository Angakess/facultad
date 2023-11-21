package ar.edu.unlp.info.oo1.parcialLiquidacion;

import java.util.List;
import java.util.stream.Collectors;
import java.util.ArrayList;

public class Sistema {
	private List<Empleado> nomina;
	
	public Sistema() {
		this.nomina = new ArrayList<Empleado>();
	}
	
	public void registrarEmpleado(Empleado empleado) {
		this.nomina.add(empleado);
	}
	public Empleado buscarEmpleado(int cuil) {
		return this.nomina.stream()
				.filter(e -> e.getCuil() == cuil)
				.findFirst()
				.orElse(null);
	}
	public void eliminarEmpleado(Empleado empleado) {
		this.nomina.remove(empleado);
	}
	public void cargarContrato(Empleado empleado, Contrato contrato) {
		empleado.cargarContrato(contrato);
	}
	public List<Recibo> calcularRecibos() {
		return this.nomina.stream()
				.map(e -> e.calcularRecibo())
				.collect(Collectors.toList());
	}
	public List<Empleado> getEmpleadosConVencido(){
		return this.nomina.stream()
			.filter(e -> e.getContratos().stream().anyMatch(c -> c.estaVencido()))
			.collect(Collectors.toList());
	}
}
