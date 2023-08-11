/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema3;

/**
 *
 * @author andre
 */
public class Estante {
    private int DF = 20;
    private int dimL;
    private Libro vector[] = new Libro[DF];
    
    public Estante(){
        dimL = 0;
    }
    public int getDF(){
        return DF;
    }
    public int getDimL(){
        return dimL;
    }
    public Libro[] getVector(){
        return vector;
    }
    public int InformarAlmacenados(){
        int aux = dimL;
        if(dimL > DF){
            aux = DF;
        }
        return aux;   
    }
    public void AgregarLibro(Libro l){
        if(dimL<DF){
            vector[dimL] = l;
            dimL++;
        }
    }
    
    public boolean InformarLleno(){
        boolean aux = false;
        if(this.InformarAlmacenados() == DF){
            aux = true;
        }
        return aux;
    }
    
    public Libro DevolverTitulo(String unTitulo){
        Libro aux = null;
        int pos = 0;
        while((pos< dimL)&&!(vector[pos].getTitulo().equals(unTitulo))){
            pos++;
        }
        if(pos < dimL){
            aux = vector[pos];
        }
        
        return aux;
    }
}
