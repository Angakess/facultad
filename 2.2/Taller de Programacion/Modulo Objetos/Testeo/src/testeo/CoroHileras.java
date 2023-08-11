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
public class CoroHileras extends Coro {

    private Corista[][] hileras;
    private int DimF;
    private int DimL;
    private int HileraL;

    public CoroHileras(Director director, int cantidadFilas) {
        super(director);
        this.DimF = cantidadFilas;
        this.DimL = 0;
        this.HileraL = 0;
        this.hileras = new Corista[this.DimF][this.DimF];
    }
    
    @Override
    public void agregarCorista(Corista corista) {
        if (!this.coroLleno()){
            this.hileras[this.HileraL][this.DimL] = corista;
            this.DimL++;  
                
            if (this.DimL == this.DimF){
                if (this.HileraL < this.DimF){
                    this.HileraL++;
                    this.DimL = 0;
                }
            }
        }
    }

    @Override
    public boolean coroLleno() {
        return this.HileraL == this.DimF;
    }

    @Override
    public boolean coroBienFormado() {
        
    }
    
}
