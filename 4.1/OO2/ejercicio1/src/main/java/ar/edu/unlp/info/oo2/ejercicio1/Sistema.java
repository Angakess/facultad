package ar.edu.unlp.info.oo2.ejercicio1;

import java.util.List;
import java.util.ArrayList;

public class Sistema {
	private List<Usuario> usuarios;
	
	public Sistema() {
		this.usuarios = new ArrayList<Usuario>();
	}
	
	public void agregarUsuario(Usuario u) {
		if (this.usuarios.stream().anyMatch(user -> user.getScreenName().equals(u.getScreenName()))){
			System.out.print("Ya existe un usuario con ese nombre");
		}
		else {
			this.usuarios.add(u);
		}
	}
}
