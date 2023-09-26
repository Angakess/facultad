package ar.edu.unlp.info.oo1.ejercicio6;

import java.util.List;
import java.util.ArrayList;

public class Farola {
	private boolean on;
	private List<Farola> neighbors;
	
	public Farola() {
		this.on = false;
		this.neighbors = new ArrayList<Farola>();
	}
	
	public List<Farola> getNeighbors(){
		return this.neighbors;
	}
	
	public void pairWithNeighbor(Farola otraFarola) {
		if(!this.neighbors.contains(otraFarola)) {
			this.neighbors.add(otraFarola);
			otraFarola.pairWithNeighbor(this);
		}
	}
	
	public void turnOn() {
		if(!on) {
			on = true;
			this.neighbors.stream().forEach(f -> f.turnOn());
		}
	}
	public void turnOff() {
		if(on) {
			on = false;
			this.neighbors.stream().forEach(f -> f.turnOff());
		}
	}
	
	public boolean isOn() {
		return this.on;
	}
}
