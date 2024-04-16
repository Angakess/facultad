package ar.edu.unlp.info.oo2.ejercicio8;

import java.time.Duration;
import java.time.LocalTime;

public class Finished extends State{
	private LocalTime finishedTime;
	
	public Finished() {
		this.finishedTime = LocalTime.now();
	}
	
	public Duration workedTime(LocalTime st) {
		return Duration.between(st, this.finishedTime);
	}
	
	public boolean checkForComment() {
		return false;
	}
}
