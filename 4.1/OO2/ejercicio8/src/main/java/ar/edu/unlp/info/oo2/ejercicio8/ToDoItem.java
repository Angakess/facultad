package ar.edu.unlp.info.oo2.ejercicio8;

import java.time.*;
import java.util.List;

public class ToDoItem {
	private String nombre;
	private List<String> comentarios;
	private State estado;
	private LocalTime startTime;
	
	public ToDoItem(String nombre) {
		this.nombre = nombre;
		this.estado = new Pending();
		this.startTime = null;
		
	}
	public void setState(State estado) {
		this.estado = estado;
	}
	
	public void start() {
		this.estado.start(this);
		this.startTime = LocalTime.now();
	}
	
	public void togglePause() {
		this.estado.togglePause(this);
	}
	
	public void finish() {
		this.estado.finish(this);
	}
	
	public Duration workedTime() {
		return this.estado.workedTime(this.startTime);
	}
	
	//------------------------------------------------------------------------------------------------------------
	
	public void addComent(String comment) {
		if(this.estado.checkForComment()) {
			this.agregarComentario(comment);
		}
		else{
			throw new RuntimeException("Error: Solo se puede agregar comentarios a un item en progreso o pausado");
		};
		
	}
	private void agregarComentario(String comment) {
		this.comentarios.add(comment);
	}

}
