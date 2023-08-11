/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema4;

/**
 *
 * @author andre
 */
public abstract class Empleado {
    private String nombre;
    private double sueldo;
    private double años;

    public Empleado(String nombre, double sueldo, int años) {
        setNombre(nombre);
        setSueldo(sueldo);
        setAños(años);
    }
    
    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public double getAños() {
        return años;
    }

    public void setAños(int años) {
        this.años = años;
    }
    
    public abstract double calcularEfectividad();
    public abstract double calcularSueldoACobrar();
    
    public String toString() {
        return "Nombre: "+getNombre()+" Sueldo a cobrar: "+calcularSueldoACobrar()+" Efectividad: "+calcularEfectividad();
    }
}
