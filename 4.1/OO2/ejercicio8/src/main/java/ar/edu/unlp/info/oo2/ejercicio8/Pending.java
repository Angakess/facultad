package ar.edu.unlp.info.oo2.ejercicio8;

public class Pending extends State{

	public Pending() {
		// TODO Auto-generated constructor stub
	}
	
	public void start(ToDoItem tdi) {
		tdi.setState(new InProgress());
	}
	
	public boolean checkForTime() {
		return false;
	}

}
