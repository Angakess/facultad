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
public class Sub_est extends Subsidio {
    private String destino;
    private float pasaje;
    private int cantDias;
    private float hotel;

    public Sub_est(String investigador, String plan, int fecha, String destino, float pasaje, int cantDias, float hotel) {
        super(investigador, plan, fecha);
        this.destino = destino;
        this.pasaje = pasaje;
        this.cantDias = cantDias;
        this.hotel = hotel;
    }
    
    public float calcularMontoTotal(){
        return (this.pasaje + (this.cantDias * this.hotel));
    }
    
    @Override
    public String toString(){
        return(super.toString()+"  || Destino: "+this.destino+"    || Dias de estadia: "+this.cantDias);
    }
}
