package ar.edu.unlp.info.oo1.ejercicio5;

import java.util.Date;

public class Mamifero {
	private String id;
	private String especie;
	private Date fechaNacimiento;
	private Mamifero madre;
	private Mamifero padre;
	
	public Mamifero(String id) {
		this.id = id;
	}
	
	public Mamifero() {
		
	}
	
	public String getIdentificador() {
		return id;
	}
	public void setIdentificador(String id) {
		this.id = id;
	}
	public String getEspecie() {
		return especie;
	}
	public void setEspecie(String especie) {
		this.especie = especie;
	}
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public Mamifero getMadre() {
		return madre;
	}
	public void setMadre(Mamifero madre) {
		this.madre = madre;
	}
	public Mamifero getPadre() {
		return padre;
	}
	public void setPadre(Mamifero padre) {
		this.padre = padre;
	}
	
	public Mamifero getAbueloMaterno() {
		if(this.getMadre() != null) {
			return this.getMadre().getPadre();
		}
		return null;
	}
	public Mamifero getAbuelaMaterna() {
		if(this.getMadre() != null) {
			return this.getMadre().getMadre();
		}
		return null;
	}
	public Mamifero getAbueloPaterno() {
		if(this.getPadre() != null) {
			return this.getPadre().getPadre();
		}
		return null;
	}
	public Mamifero getAbuelaPaterna() {
		if(this.getPadre() != null) {
			return this.getPadre().getMadre();
		}
		return null;
	}
	
	public boolean tieneComoAncestroA(Mamifero unMamifero) {
		return ((this.getMadre() != null && this.esAncestro(this.getMadre(), unMamifero)) || (this.getPadre() != null && this.esAncestro(this.getPadre(), unMamifero)));
	}
	private boolean esAncestro(Mamifero pariente, Mamifero unMamifero) {
		return (pariente != null && (pariente.equals(unMamifero) || pariente.tieneComoAncestroA(unMamifero)));
	}
}
