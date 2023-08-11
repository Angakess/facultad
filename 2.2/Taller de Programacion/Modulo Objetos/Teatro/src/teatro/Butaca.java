/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teatro;

/**
 *
 * @author andre
 */
public class Butaca {
    private String desc;
    private double precio;
    private boolean ocupado;

    public Butaca(int i, int j) {
        this.desc = "Butaca "+(i+1)+","+(j+1);
        this.precio = 800+100*(i+1);
        this.ocupado = false;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public boolean isOcupado() {
        return ocupado;
    }

    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }

    @Override
    public String toString() {
        return "Butaca{" + "Lugar= " + desc + ", precio= " + precio + ", ocupado= " + ocupado + '}';
    }
    
    
    
}
