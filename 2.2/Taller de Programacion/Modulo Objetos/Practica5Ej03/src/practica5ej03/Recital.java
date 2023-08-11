/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica5ej03;

/**
 *
 * @author andre
 */
public abstract class Recital {
    private String banda;
    private int cantTemas;
    private int dimL;
    private String[] vector;

    public Recital(String banda, int cantTemas) {
        this.banda = banda;
        this.cantTemas = cantTemas;
        this.dimL = 0;
        this.vector = new String[cantTemas];
    }

    public String getBanda() {
        return banda;
    }

    public void setBanda(String banda) {
        this.banda = banda;
    }

    public int getCantTemas() {
        return cantTemas;
    }

    public void setCantTemas(int cantTemas) {
        this.cantTemas = cantTemas;
    }

    public String[] getVector() {
        return vector;
    }

    public void setVector(String[] vector) {
        this.vector = vector;
    }

    public int getDimL() {
        return dimL;
    }

    public void setDimL(int dimL) {
        this.dimL = dimL;
    }
    
    public void agregarTema(String unTema){
        if(dimL < cantTemas){
            vector[dimL] = unTema;
            dimL++;
        }
        else{
            System.out.println("No se puede agregar mas temas.");
        }
    }
    
    public String actuar(){
        String aux="\n";
        for(int i=0; i<dimL; i++){
            aux += "y ahora tocaremos..."+vector[i]+"\n";
        }
        return aux;
    }
    
    public abstract double calcularCosto();
    
}
