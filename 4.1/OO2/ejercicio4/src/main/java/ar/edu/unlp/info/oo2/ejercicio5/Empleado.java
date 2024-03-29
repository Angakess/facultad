package ar.edu.unlp.info.oo2.ejercicio5;

public abstract class Empleado {
	protected boolean casado;
	protected int hijos;
	
	public double sueldo1() {
		return (this.basico() + this.adicional1() - this.descuento()); 
	}
	
	public double basico() {
		return 0;
	}
	public double adicional1() {
		return 0;
	}
	public double descuento() {
		return (0.13 * this.basico() + 0.05 * this.adicional1());
	}
	
	//-------------------------------------------------------------
	
	public double sueldo2() {
		return (this.basico() + this.adicional2() - this.descuento()); 
	}
	
	public double adicional2() {
		double total = 0;
		if(this.casado) {
			total = total + 5000; 
		}
		total = total + (this.hijos * 2000);
		return total;
	}

}
