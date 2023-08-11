/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testeo;

/**
 *
 * @author alumnos
 */
public class Corista extends Persona {
    private int tono;

    public Corista( String nom, int d, int ed, int tono) {
        super(nom, d, ed);
        this.tono = tono;
    }

    public int getTono() {
        return tono;
    }

    public void setTono(int tono) {
        this.tono = tono;
    }
    
    
}
