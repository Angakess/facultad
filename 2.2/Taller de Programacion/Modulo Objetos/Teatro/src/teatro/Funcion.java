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
public class Funcion {
    private String titulo;
    private int fecha;
    private double hora;
    private int DF;
    private int DC;
    private Butaca[][] matriz;

    public Funcion(String titulo, int fecha, double hora, int DF, int DC) {
        this.titulo = titulo;
        this.fecha = fecha;
        this.hora = hora;
        this.DF = DF;
        this.DC = DC;
        this.matriz = new Butaca[DF][DC];
        for(int i=0; i<DF; i++){
            for(int j=0; j<DC; j++){
                matriz[i][j]= new Butaca(i,j);
            }
        }
    }
    
    public double ocuparButacaEInformarPrecio(int f, int b){
        matriz[f-1][b-1].setOcupado(true);
        return (matriz[f-1][b-1].getPrecio());
    }
    public void desocuparFila(int f){
        for(int j=0; j<DC; j++){
            matriz[f-1][j].setOcupado(false);
        }
    }
    public String informarTodoB(int b){
        String aux = "";
        for(int i=0; i<DF; i++){
            aux += "\n"+matriz[i][b];
        }
        return aux;
    }
    
    @Override
    public String toString(){
        String aux = "Titulo: "+titulo+", fecha: "+fecha+", hora: "+hora;
        for(int j=0; j<DC; j++){
            aux += "\n"+"Columna: "+(j+1)+"\n"+this.informarTodoB(j)+"\n";
        }
        return aux;
    }
    
    
}
