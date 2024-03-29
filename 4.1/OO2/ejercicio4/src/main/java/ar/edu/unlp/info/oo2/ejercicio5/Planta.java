package ar.edu.unlp.info.oo2.ejercicio5;

public class Planta extends Empleado{
	private int antiguedad;
	
	public Planta(boolean casado, int hijos, int antiguedad) {
		this.casado = casado;
		this.hijos = hijos;
		this.antiguedad = antiguedad;
	}
	
	public double basico() {
		return 50000;
	}
	public double adicional1() {
		double total = 0;
		if(this.casado) {
			total = total + 5000;
		}
		total = total + (this.hijos * 2000);
		total = total + (this.antiguedad * 2000);
		return total;
	}
	
	//-------------------------------------------------------------
	
	public double adicional2() {
		double total = super.adicional2();
		total = total + (this.antiguedad * 2000);
		return total;
	}

}
