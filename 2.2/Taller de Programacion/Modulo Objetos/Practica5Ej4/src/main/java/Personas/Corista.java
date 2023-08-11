/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Personas;

/**
 *
 * @author bonac
 */
public class Corista extends Persona {
    
    private int tono;

    public Corista(String nombre, int DNI, int edad, int tono) {
        super(nombre, DNI, edad);
        this.tono = tono;
    }

    public int getTono() {
        return tono;
    }

    public void setTono(int tono) {
        this.tono = tono;
    }    
    
    public String toString()
    {
        return "Corista " + super.toString() + " | Tono Fundamental: " + this.tono;
    }
}
