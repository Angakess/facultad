/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package final_22;

/**
 *
 * @author andre
 */
public abstract class Subsidio {
    private String investigador;
    private String plan;
    private int fecha;

    public Subsidio(String investigador, String plan, int fecha) {
        this.investigador = investigador;
        this.plan = plan;
        this.fecha = fecha;
    }
    
    public abstract float calcularMontoTotal();
    
    @Override
    public String toString(){
        return ("Nombre del investigador: "+this.investigador+" || Plan de trabajo: "+this.plan+"   || Fecha: "+this.fecha+"    || Monto total: "+calcularMontoTotal());
    }
    
}
