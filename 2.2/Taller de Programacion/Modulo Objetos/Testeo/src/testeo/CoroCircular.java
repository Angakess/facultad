/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testeo;

/**
 *
 * @author alumnos
 */
public class CoroCircular extends Coro {

    private int DimF;
    private int DimL;
    private Corista[] coristas;
    
    public CoroCircular(Director director, int cantidadCoristas) {
        super(director);
        this.DimF = cantidadCoristas;
        this.DimL = 0;
        this.coristas = new Corista[this.DimF];
    }

    @Override
    public void agregarCorista(Corista corista) {
        if (!this.coroLleno()){
            this.coristas[this.DimL] = corista;
            this.DimL++;
        }
    }

    @Override
    public boolean coroLleno() {
        return this.DimL == this.DimF;
    }

    @Override
    public boolean coroBienFormado() {
        int mayorTono = this.coristas[0].getTono();
        int i = 0;
        while(i < this.DimL-1 && this.coristas[i+1].getTono() < mayorTono){
            i++;
            mayorTono = this.coristas[i].getTono();
        }
       
        return i == this.DimL - 1;
    }
    
}
