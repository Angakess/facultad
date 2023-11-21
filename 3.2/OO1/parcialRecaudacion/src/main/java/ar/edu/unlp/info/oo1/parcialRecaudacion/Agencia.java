package ar.edu.unlp.info.oo1.parcialRecaudacion;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.ArrayList;

public class Agencia {
	private List<Contribuyente> contribuyentes;
	
	public Agencia() {
		this.contribuyentes = new ArrayList<Contribuyente>();
	}
	
	public void agregarContribuyente(Contribuyente c) {
		this.contribuyentes.add(c);
	}
	
	public List<Contribuyente> topContribuyentes(int n, String l){
		return this.contribuyentes.stream()
				.filter(contribuyente -> contribuyente.getLocalidad().equals(l))
				.sorted((c1, c2) -> Double.compare(c2.calcularImpuesto(), c1.calcularImpuesto()))
				.limit(n)
				.collect(Collectors.toList());
	}
	
	public List<Contribuyente> getContribuyentes(){
		return this.contribuyentes;
	}
}
