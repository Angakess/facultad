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
public class Entrenador extends Empleado{
    private int nCamp;

    public Entrenador(String unNombre, double unSueldo, int años, int nCamp) {
        super(unNombre,unSueldo,años);
        setnCamp(nCamp);
    }

    public int getnCamp() {
        return nCamp;
    }

    public void setnCamp(int nCamp) {
        this.nCamp = nCamp;
    }
    
    public double calcularEfectividad(){
        return (getnCamp()/getAños());
    }
    public double calcularSueldoACobrar(){
        if((getnCamp()>= 1)&&(getnCamp()<= 4)){
            return (getSueldo() + getSueldo()*getAños()*0.1 + 5000);
        }
        if((getnCamp()>= 5)&&(getnCamp()<= 10)){
            return (getSueldo() + getSueldo()*getAños()*0.1 + 30000);
        }
        if((getnCamp()> 10)){
            return (getSueldo() + getSueldo()*getAños()*0.1 + 50000);
        }
        return getSueldo() + getSueldo()*getAños()*0.1;
    }
    
    public String toString(){
        return "Entrenador ("+super.toString()+")";
    }
    
    public String informar(){
        return "Nombre: "+getNombre()+" sueldo basico: "+getSueldo()+" antiguedad: "+getAños()+" campeonatos ganados: "+getnCamp();
    }
}
