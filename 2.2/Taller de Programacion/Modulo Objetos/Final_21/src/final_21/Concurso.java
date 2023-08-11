/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package final_21;

/**
 *
 * @author andre
 */
public class Concurso {
    private int cantN;
    private int dimL;
    private Pareja[] vector;

    public Concurso(int cantN) {
        this.cantN = cantN;
        this.dimL = 0;
        this.vector = new Pareja[cantN];
    }
    
    public void agregarPareja(Pareja unaPareja){
        if(dimL < cantN){
            vector[dimL] = unaPareja;
            dimL++;
        }
    }
    
    public Pareja difMax(){
        int max = -1;
        int iMax = -1;
        for(int i=0; i<dimL; i++){
            if(vector[i].calcularDif() > max){
                max = this.vector[i].calcularDif();
                iMax = i;
            }
        }
        if (iMax == -1){
            System.out.println("No hay parejas");
            return null;
        }
        else{
            return (this.vector[iMax]);
        }
    }
}
