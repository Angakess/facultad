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
public class Practica5Ej03 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Evento evt = new Evento("a beneficio","St Jude's","20/6","Daft Punk", 4);
        Gira gir = new Gira("2022 Tour",9,"Esteman",8);
        
        System.out.println("Costo del evento: "+evt.calcularCosto());
        System.out.println("Costo de la gira: "+gir.calcularCosto());
        
        Fecha fec = new Fecha("Buenos Aires",8);
        
        evt.agregarTema("Get Lucky");
        evt.agregarTema("One More Time");
        gir.agregarTema("Baila");
        gir.agregarTema("On Top");
        gir.agregarTema("Mr Trance");
        
        gir.agregarFecha(fec);
        
        System.out.println(evt.actuar());
        System.out.println(gir.actuar());
        
    }
    
}
