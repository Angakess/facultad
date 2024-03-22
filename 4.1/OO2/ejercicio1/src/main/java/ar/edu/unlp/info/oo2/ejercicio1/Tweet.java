package ar.edu.unlp.info.oo2.ejercicio1;

public class Tweet {
	private String texto;
	//private int charMin;
	//private int charMax;
	
	/*
	public Tweet(String texto) {
		this.charMin = 1;
		this.charMax = 280;
		if((texto.length() >= this.charMin)&&(texto.length() <= this.charMax)) {
			this.texto = texto;
		}
		else {
			System.out.print("");
		}
	}
	*/
	public Tweet(String texto) {
		this.texto = texto;
	}
	public String getTexto() {
		return this.texto;
	}
	
}

