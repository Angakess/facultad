package ar.edu.unlp.info.oo2.ejercicio8;

import java.time.Duration;
import java.time.LocalTime;

public abstract class State {

	public void start(ToDoItem tdi) {
		
	};
	
	public void togglePause(ToDoItem tdi) {
		throw new RuntimeException("Error: Debe estar pausado o in-progress");
	};
	
	public void finish(ToDoItem tdi) {
		
	};
	
	public Duration workedTime(LocalTime st) {
		throw new RuntimeException("Error: Debe estar iniciado");
	};
	
	public boolean checkForComment(){
		return true;
	};

}
