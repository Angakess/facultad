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
public class Triangulo {
    private double lado;
    private String relleno;
    private String linea;
    
    public Triangulo(double lados, String rellenos, String lineas){
        lado = lados;
        relleno = rellenos;
        linea = lineas;
    }
    public Triangulo(){
        
    }
    
    public double getLado(){
        return lado;
    }
    public String getRelleno(){
        return relleno;
    }
    public String getLinea(){
        return linea;
    }
    
    public void setLado(double lados){
        lado = lados;
    }
    public void setRelleno(String rellenos){
        relleno = rellenos;
    }
    public void setLineas(String lineas){
        linea = lineas;
    }
    
    public double getPerimetro(){
        double p = lado * 3;
        return p;
    }
    public double getArea(){
        double s = (this.getPerimetro()/2);
        double area = Math.sqrt(s*((s - lado)*3));
        return area;
    }
}
