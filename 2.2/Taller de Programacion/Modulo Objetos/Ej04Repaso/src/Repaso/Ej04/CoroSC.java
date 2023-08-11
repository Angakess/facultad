/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repaso.Ej04;

/**
 *
 * @author andre
 */
public class CoroSC extends Coro {
    private int DF;
    private int dimL;
    private Corista vector[];

    public CoroSC(int DF, String nombreC, Director dir) {
        super(nombreC,dir);
        this.DF = DF;
        this.dimL = 0;
        this.vector = new Corista[DF];
    }
    
    public int getDF() {
        return DF;
    }

    public void setDF(int DF) {
        this.DF = DF;
    }

    public int getDimL() {
        return dimL;
    }

    public void setDimL(int dimL) {
        this.dimL = dimL;
    }

    public Corista[] getVector() {
        return vector;
    }

    public void setVector(Corista[] vector) {
        this.vector = vector;
    }
    
    public boolean CoroLleno(){
        return (dimL == DF);
    }
    
    public void AgregarCorista(Corista cor){
        if (!(this.CoroLleno())){
            vector[dimL] = cor;
            dimL++;
        }
        else{
            System.out.println("El coro esta lleno");
        }
    }
    
    public boolean InformarOrdenando(){
        int pos = 0;
        int tonoMin = 9999;
        if (this.CoroLleno()){
            while((pos < DF)&&(vector[pos].getTono() < tonoMin)){
                tonoMin = vector[pos].getTono();
                pos++;
            }
            return (pos == DF);
        }
        else{
            System.out.println("Falta llenar el coro");
            return false;
        }
    }

    @Override
    public String toString() {
        String aux = "\n"+"Coristas:: "+"\n";
        if(dimL == 0){
            aux = "\n"+"No hay coristas. "+"\n";
        }
        for (int i=0; i < dimL; i++){
            aux = aux + "corista "+ (i+1) +": "+ vector[i]+"\n";
        }
        return "Informacion del coro semicircular: " + super.toString() + "\n"+aux;
    }
    
}
    

