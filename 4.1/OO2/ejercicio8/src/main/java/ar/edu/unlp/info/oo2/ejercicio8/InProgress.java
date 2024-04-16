package ar.edu.unlp.info.oo2.ejercicio8;

import java.time.Duration;
import java.time.LocalTime;

public class InProgress extends State{

	public InProgress() {
		// TODO Auto-generated constructor stub
	}
	
	public void togglePause(ToDoItem tdi) {
		tdi.setState(new Paused());
	}
	
	public void finish(ToDoItem tdi) {
		tdi.setState(new Finished());
	}
	
	public Duration workedTime(LocalTime st) {
		return Duration.between(st, LocalTime.now());
	}
}
