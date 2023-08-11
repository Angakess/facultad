/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema3;
import PaqueteLectura.Lector;
/**
 *
 * @author andre
 */
public class CrearTriangulo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Triangulo t = new Triangulo();
        System.out.println("Ingrese el largo de los 3 lados: ");
        t.setLado(Lector.leerDouble());
        System.out.println("Ingrese el color del relleno: ");
        t.setRelleno(Lector.leerString());
        System.out.println("Ingrese el color de las lineas: ");
        t.setLineas(Lector.leerString());
        
        System.out.println("El perimetro es "+t.getPerimetro());
        System.out.println("El area es "+t.getArea());
    }
    
}
