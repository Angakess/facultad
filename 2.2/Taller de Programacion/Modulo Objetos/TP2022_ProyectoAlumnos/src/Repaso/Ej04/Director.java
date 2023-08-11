/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repaso.Ej04;

/**
 *
 * @author andre
 */
public class Director extends Persona {
    private int antiguedad;

    public Director(String nombre, int dni, int edad,int antiguedad) {
        super(nombre, dni, edad);
        this.antiguedad = antiguedad;
    }

    public int getAntiguedad() {
        return antiguedad;
    }

    public void setAntiguedad(int antiguedad) {
        this.antiguedad = antiguedad;
    }

    @Override
    public String toString() {
        return "Datos del director: " + super.toString() + ", antiguedad= " + antiguedad;
    }
    
    
}
