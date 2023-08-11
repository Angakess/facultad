/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema4;

import PaqueteLectura.GeneradorAleatorio;

/**
 *
 * @author andre
 */
public class Ej02P4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GeneradorAleatorio.iniciar();
        Jugador jug = new Jugador(GeneradorAleatorio.generarString(5),
                GeneradorAleatorio.generarDouble(2000),
                GeneradorAleatorio.generarInt(15),
                GeneradorAleatorio.generarInt(30),
                GeneradorAleatorio.generarInt(200));
        
        Entrenador ent = new Entrenador(GeneradorAleatorio.generarString(5),
                GeneradorAleatorio.generarDouble(2000),
                GeneradorAleatorio.generarInt(15),
                GeneradorAleatorio.generarInt(20));
        
        System.out.println(jug.informar());
        System.out.println(jug);
   
        System.out.println(ent.informar());
        System.out.println(ent);
        
    }
    
}
