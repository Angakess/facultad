/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica5ej02;

import PaqueteLectura.GeneradorAleatorio;
import PaqueteLectura.Lector;

/**
 *
 * @author andre
 */
public class Practica5Ej02 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GeneradorAleatorio.iniciar();
        Estacionamiento est = new Estacionamiento("Park Avenue","3 e/ 200 y 201","9:00","22:00",3,3);
        for(int i=0; i<6; i++){
            //System.out.println("Ingrese el nombre del dueño: ");
            String dueño = GeneradorAleatorio.generarString(8);
            //System.out.println("Ingrese la patente del auto: ");
            String patente = GeneradorAleatorio.generarString(6);
            System.out.println("Ingrese el numero de piso: ");
            int x = Lector.leerInt();
            System.out.println("Ingrese el numero de plaza: ");
            int y = Lector.leerInt();
            System.out.println("");
            Auto aut = new Auto(dueño, patente);
            est.registrarAuto(aut, (x-1), (y-1));
        }
        System.out.println(est.libreYOcupado());
        System.out.println(est.contarEnPlazas(1)+" autos encontrados.");
        System.out.println("Ingrese una patente a buscar: ");
        String pate = Lector.leerString();
        System.out.println(est.buscarPatente(pate));
    }
   
}
