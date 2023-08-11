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
public class CoroH extends Coro{
    private int DF;
    private int DC;
    private int dimLF;
    private int dimLC;
    private Corista matriz[][];

    public CoroH(int DF, int DC, String nombreC, Director dir) {
        super(nombreC,dir);
        this.DF = DF;
        this.DC = DC;
        this.dimLF = 0;
        this.dimLC = 0;
        this.matriz = new Corista[DF][DC];
    }

    public int getDF() {
        return DF;
    }

    public void setDF(int DF) {
        this.DF = DF;
    }

    public int getDC() {
        return DC;
    }

    public void setDC(int DC) {
        this.DC = DC;
    }

    public int getDimLF() {
        return dimLF;
    }

    public void setDimLF(int dimLF) {
        this.dimLF = dimLF;
    }

    public int getDimLC() {
        return dimLC;
    }

    public void setDimLC(int dimLC) {
        this.dimLC = dimLC;
    }

    public Corista[][] getMatriz() {
        return matriz;
    }

    public void setMatriz(Corista[][] matriz) {
        this.matriz = matriz;
    }
    
    public boolean CoroLleno(){
        return (dimLF == DF);
    }
    public boolean HileraLlena(){
        return (dimLC == DC);
    }
    
    public void AgregarCorista(Corista cor){
        if (!(this.CoroLleno())){
            matriz[dimLF][dimLC] = cor;
            dimLC++;
            if(this.HileraLlena()){    //Si la fila esta llena pasa a la fila de abajo y resetea la dimL de columnas
                dimLF++;
                dimLC = 0;
                
            }
        }
        else{
            System.out.println("El coro esta lleno");
        }
    }
    
    public boolean InformarOrdenando(){
        int posX = 0;
        int posY = 0;
        int tonoMin = 9999;
        int tonoAct;
        if (this.CoroLleno()){
            while((posX < DF)&&(matriz[posX][posY].getTono() < tonoMin)){
                tonoMin = matriz[posX][posY].getTono();
                tonoAct = matriz[posX][posY].getTono();
                while((posY < DC)&&(matriz[posX][posY].getTono() == tonoAct)){
                    posY++;
                }
                if(posY != DC){
                    return false;
                }
                else{
                    posX++;
                    posY = 0;
                }
            }
            return(posX == DF);
        }
        else{
            System.out.println("Falta llenar el coro");
            return false;
        }
    }
    @Override
    public String toString() {
        String aux = "\n"+"Coristas:: "+"\n";
        if((dimLF == 0)&&(dimLC == 0)){
            aux = "\n"+"No hay coristas. "+"\n";
        }
        else{
            for (int i=0; i <= dimLF; i++){
                if(i+1 > dimLF){
                    for(int j=0; j < dimLC; j++){   //!!!Si llega a i = 3 significa que antes quedo dimLC = 0, este ciclo no se activa, por eso no se rompe el tema de indices, 
                                                    //no se si eso estara bien tecnicamente pero funca
                        aux = aux + "corista "+(i+1)+"."+(j+1)+": " + matriz[i][j]+"\n";
                    }
                }                                           
                else{
                    for(int j=0; j < DC; j++){      //Si estamos en una hilera llena podemos ir hasta el max (DC)
                        aux = aux + "corista "+(i+1)+"."+(j+1)+": " + matriz[i][j]+"\n";
                    }
                }
            }
        }

            
            
            //        aux = aux + "corista "+(i+1)+"."+(j+1)+": " + matriz[i][j]+"\n";
 
        return "Informacion del coro de hileras: " + super.toString() +"\n"+ aux;
    }
    
}
