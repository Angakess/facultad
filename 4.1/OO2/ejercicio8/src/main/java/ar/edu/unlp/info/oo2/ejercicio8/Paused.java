package ar.edu.unlp.info.oo2.ejercicio8;

import java.time.Duration;
import java.time.LocalTime;

public class Paused extends State{

	public Paused() {
		// TODO Auto-generated constructor stub
	}
	
	public void togglePause(ToDoItem tdi) {
		tdi.setState(new InProgress());
	}
	
	public void finish(ToDoItem tdi) {
		tdi.setState(new Finished());
	}
	
	public Duration workedTime(LocalTime st) {
		return Duration.between(st, LocalTime.now());
	}
}
