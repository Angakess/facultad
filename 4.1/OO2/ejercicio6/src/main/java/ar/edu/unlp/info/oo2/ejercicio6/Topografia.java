package ar.edu.unlp.info.oo2.ejercicio6;

public abstract class Topografia { 
	protected double propAgua;
	
	public double getProporcionAgua() {
		return this.propAgua;
	};
	
	public double getProporcionTierra() {
		return 1 - this.getProporcionAgua();
	}
	
	public Object getTopografia(){
		return this;
	}
	
	public boolean isEquals(Topografia topo) {
		return this.getProporcionAgua() == topo.getProporcionAgua();
	};
	
	public boolean equals(Object obj) {
		return this.isEquals((Topografia) obj); //????
	}
}
