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
public class Bien {
    private String desc;
    private int cant;
    private float costo;

    public Bien(String desc, int cant, float costo) {
        this.desc = desc;
        this.cant = cant;
        this.costo = costo;
    }
    
    public String getDesc() {
        return desc;
    }
    
    public int getCant() {
        return cant;
    }

    public float getCosto() {
        return costo;
    }
    
    
}
