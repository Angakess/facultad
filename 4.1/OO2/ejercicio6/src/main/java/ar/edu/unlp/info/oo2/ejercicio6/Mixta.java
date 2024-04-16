package ar.edu.unlp.info.oo2.ejercicio6;

import java.util.List;
import java.util.ArrayList;

public class Mixta extends Topografia{
	private List<Topografia> topografias;
	
	public Mixta() {
		this.topografias = new ArrayList<Topografia>();
	}
	
	public double getProporcion() {
		double total = topografias.stream()
				.mapToDouble(topo -> topo.getProporcionAgua())
				.sum();
		return (total / 4);
	}
	public List<Topografia> getTopografia(){
		return this.topografias;
	}
	
	public boolean isEquals(Topografia topografia) {
		return this.topografias.equals(topografia.getTopografia());
	}
	
	public void agregarTopografia(Topografia t) {
		topografias.add(t);
	}
	
}
