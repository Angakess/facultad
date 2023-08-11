/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica5ej02;

/**
 *
 * @author andre
 */
public class Estacionamiento {
    private String nombre;
    private String dir;
    private String hora_cls;
    private String hora_op;
    private int DF;
    private int DC;
    //private int dimLF;
    //private int dimLC;
    private Auto[][] matriz;

    public Estacionamiento(String nombre, String dir) {
        this.nombre = nombre;
        this.dir = dir;
        this.hora_cls = "21:00";
        this.hora_op = "8:00";
        this.DF = 5;
        this.DC = 10;
        //this.dimLF = 0;
       // this.dimLC = 0;
        this.matriz = new Auto[DF][DC];
    }

    public Estacionamiento(String nombre, String dir, String hora_cls, String hora_op, int DF, int DC) {
        this.nombre = nombre;
        this.dir = dir;
        this.hora_cls = hora_cls;
        this.hora_op = hora_op;
        this.DF = DF;
        this.DC = DC;
        //this.dimLF = 0;
        //this.dimLC = 0;
        this.matriz = new Auto[DF][DC];
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    public String getHora_cls() {
        return hora_cls;
    }

    public void setHora_cls(String hora_cls) {
        this.hora_cls = hora_cls;
    }

    public String getHora_op() {
        return hora_op;
    }

    public void setHora_op(String hora_op) {
        this.hora_op = hora_op;
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
    
    public Auto[][] getMatriz() {
        return matriz;
    }

    public void setMatriz(Auto[][] matriz) {
        this.matriz = matriz;
    }
    
    public void registrarAuto(Auto a, int x, int y){
        matriz[x][y]= a;
    }
    
    public String buscarPatente(String unaPat){
        int i = 0;
        int j = 0;
        while((i<DF)&&((matriz[i][j] == null)||(!(unaPat.equals(matriz[i][j].getPat()))))){
            while((j<DC)&&((matriz[i][j] == null)||(!(unaPat.equals(matriz[i][j].getPat()))))){
                j++;
            }
            if(j == DC){
                j = 0;
                i++;
            }
            else{
                return "Piso: "+(i+1)+", plaza: "+(j+1);
            }
        }
        if(i == DF){
            return "Auto inexistente";
        }
        else{
            return "Piso: "+(i+1)+", plaza: "+(j+1);
        }
    }
    
    public String libreYOcupado() {
        String aux = "Estacionamiento: \n";
        for(int i=0; i<DF; i++){
            for(int j=0; j<DC; j++){
                if(matriz[i][j] != null){
                    aux = aux + "Piso "+(i+1)+" Plaza "+(j+1)+": "+matriz[i][j]+" || ";
                }
                else{
                    aux = aux + "Piso "+(i+1)+" Plaza "+(j+1)+": libre || ";
                }
            }
            aux += "\n";
        }
        return aux;
    }
    
    public int contarEnPlazas(int y){
        int total = 0;
        y = y-1;
        if((y >= DC)||(y < 0)){
            System.out.println("No existe ese numero de plaza");
            return -1;
        }
        for(int i=0; i<DF; i++){
            if(matriz[i][y] != null){
                total += 1;
            }
        }
        return total;
    }
}
