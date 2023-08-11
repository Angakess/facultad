/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema2;

import PaqueteLectura.Lector;

/**
 *
 * @author andre
 */
public class CrearPersona {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Persona x = new Persona();
        
        
        System.out.println("Ingrese un nombre: ");
        //x.setNombre(Lector.leerString());
        //String name = Lector.leerString();
        System.out.println("Ingrese un DNI: ");
        x.setDNI(Lector.leerInt());
        //int num = Lector.leerInt();
        System.out.println("Ingrese la edad: ");
        x.setEdad(Lector.leerInt());
        //int age = Lector.leerInt();
        //Persona x = new Persona(name,num,age);
   
      
        System.out.println(x.toString());
    }
    
}
