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
public class Jugador extends Empleado {
    private double nPartidos;
    private double nGoles;

    public Jugador(String unNombre, double unSueldo, int años, int nPartidos, int nGoles) {
        super(unNombre,unSueldo,años);
        setnPartidos(nPartidos);
        setnGoles(nGoles);
    }

    public double getnPartidos() {
        return nPartidos;
    }

    public void setnPartidos(int nPartidos) {
        this.nPartidos = nPartidos;
    }

    public double getnGoles() {
        return nGoles;
    }

    public void setnGoles(int nGoles) {
        this.nGoles = nGoles;
    }
    
    public double calcularEfectividad(){
        return (getnGoles()/getnPartidos());
    }
    public double calcularSueldoACobrar(){
        if(calcularEfectividad()> 0.5){
            return (2*getSueldo()) + (getSueldo()*getAños()*0.1);
        }
        return getSueldo() + getSueldo()*getAños()*0.1;
    }
    
    
    public String toString(){
        return "Jugador ("+super.toString()+")";
    }
    
    public String informar(){
        return "Nombre: "+getNombre()+" sueldo basico: "+getSueldo()+" antiguedad: "+getAños()+" partidos: "+getnPartidos()+" goles: "+getnGoles();
    }
}
