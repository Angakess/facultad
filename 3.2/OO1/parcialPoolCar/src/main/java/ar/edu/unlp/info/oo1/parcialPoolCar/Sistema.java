package ar.edu.unlp.info.oo1.parcialPoolCar;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.Comparator;

public class Sistema {
	private List<Usuario> usuarios;
	private List<Viaje> viajes;
	
	public Sistema() {
		this.usuarios = new ArrayList<Usuario>();
		this.viajes = new ArrayList<Viaje>();
	}
	
	public void registrarUsuario(Usuario user) {
		this.usuarios.add(user);
	}
	public Viaje registrarViaje(String or, String dest, double costo, Vehiculo v, LocalDate f) {
		Viaje viaje = new Viaje(or, dest, costo, v, f);
		this.viajes.add(viaje);
		return viaje;
	}
	public List<Viaje> listarViajesManiana() {
		return this.viajes.stream()
				.filter(v -> v.saleManiana())
				.collect(Collectors.toList());
	}
	public void procesarViajes() {
		for(Viaje v : this.viajes) {
			v.procesarViaje();
		}
	}
	public List<Usuario> listarUsuariosPorSaldo(){
		return this.usuarios.stream().sorted((u1, u2) -> comparador(u2.getSaldo(), u1.getSaldo())).collect(Collectors.toList());
	}
	private int comparador(double a, double b) {
		if(a > b) {
			return 1;
		}
		else if(a < b) {
			return -1;
		}
		else {
			return 0;
		}
	}
	public void regalarSaldo(double monto) {
		for(Usuario u : this.usuarios) {
			u.cargarSaldo(monto);
		}
	}
	
	
	
	
	
	
}
