/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Personas;

/**
 *
 * @author bonac
 */
public class Director extends Persona {
    
    private int antiguedad;

    public Director(String nombre, int DNI, int edad, int antiguedad) {
        super(nombre, DNI, edad);
        this.antiguedad = antiguedad;
    }

    public int getAntiguedad() {
        return antiguedad;
    }

    public void setAntiguedad(int antiguedad) {
        this.antiguedad = antiguedad;
    }
    
    public String toString()
    {
        return "Director " + super.toString() + " | Antiguedad: " + this.antiguedad;
    }
}
