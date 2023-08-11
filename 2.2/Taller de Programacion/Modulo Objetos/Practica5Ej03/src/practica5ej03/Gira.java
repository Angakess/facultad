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
public class Gira extends Recital{
    private String nombreGira;
    private int cantDias;
    private int dimLF;
    private Fecha[] vector;
    private int diaActual;

    public Gira(String nombreGira, int cantDias, String banda, int cantTemas) {
        super(banda, cantTemas);
        this.nombreGira = nombreGira;
        this.cantDias = cantDias;
        this.dimLF = 0;
        this.vector = new Fecha[cantDias];
    }
    
    public String getNombreGira() {
        return nombreGira;
    }

    public void setNombreGira(String nombreGira) {
        this.nombreGira = nombreGira;
    }

    public int getCantDias() {
        return cantDias;
    }

    public void setCantDias(int cantDias) {
        this.cantDias = cantDias;
    }

    public Fecha[] getVectorFecha() {
        return vector;
    }

    public void setVectorFecha(Fecha[] vector) {
        this.vector = vector;
    }

    public int getDiaActual() {
        return diaActual;
    }

    public void setDiaActual(int diaActual) {
        this.diaActual = diaActual;
    }

    public int getDimLF() {
        return dimLF;
    }

    public void setDimLF(int dimLF) {
        this.dimLF = dimLF;
    }
    
    public void agregarFecha(Fecha unaFecha){
        if(dimLF < cantDias){
            vector[dimLF] = unaFecha;
            dimLF++;
            diaActual = unaFecha.getDia();
        }
    }
    
    
    @Override
    public String actuar(){
        return ("Buenas noches ... "+vector[dimLF-1].getCiudad() + super.actuar());
    }
    
    @Override
    public double calcularCosto(){
        return (30000 * cantDias);
    }
}
