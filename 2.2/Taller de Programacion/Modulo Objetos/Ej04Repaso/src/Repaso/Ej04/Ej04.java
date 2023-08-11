/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repaso.Ej04;

import PaqueteLectura.GeneradorAleatorio;
import PaqueteLectura.Lector;

/**
 *
 * @author andre
 */
public class Ej04 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GeneradorAleatorio.iniciar();
        Director dir1 = new Director("abc",123,33,10);
        Director dir2 = new Director("zxc",789,66,20);
        CoroSC semiCirc = new CoroSC(5,"aaa",dir1);
        CoroH hileras = new CoroH(3,3,"sss",dir2);
        
        System.out.println("1) Ingrese el tono fundamental del corista: ");
        Corista cor1 = new Corista(GeneradorAleatorio.generarString(10),
                GeneradorAleatorio.generarInt(10000)+10000,
                GeneradorAleatorio.generarInt(100)+1,
                Lector.leerInt());
        while((cor1.getTono()!= 0)&&!(semiCirc.CoroLleno())){
            semiCirc.AgregarCorista(cor1);
            System.out.println("Ingrese el tono fundamental del siguiente corista: ");
            cor1 = new Corista(GeneradorAleatorio.generarString(10),
                GeneradorAleatorio.generarInt(10000)+10000,
                GeneradorAleatorio.generarInt(100)+1,
                Lector.leerInt());
        }
        
        System.out.println("2) Ingrese el tono fundamental del corista: ");
        Corista cor2 = new Corista(GeneradorAleatorio.generarString(10),
                GeneradorAleatorio.generarInt(10000)+10000,
                GeneradorAleatorio.generarInt(100)+1,
                Lector.leerInt());
        while((cor2.getTono()!= 0)&&!(hileras.CoroLleno())){
            hileras.AgregarCorista(cor2);
            System.out.println("Ingrese el tono fundamental del siguiente corista: ");
            cor2 = new Corista(GeneradorAleatorio.generarString(10),
                GeneradorAleatorio.generarInt(10000)+10000,
                GeneradorAleatorio.generarInt(100)+1,
                Lector.leerInt());
        }
        
        if(semiCirc.CoroLleno()){
            System.out.println("El coro semicircular esta lleno");
        }
        else{
            System.out.println("El coro semicircular NO esta lleno");
        }
        if(hileras.CoroLleno()){
            System.out.println("El coro de hileras esta lleno");
        }
        else{
            System.out.println("El coro de hileras NO esta lleno");
        }
        
        if(semiCirc.InformarOrdenando()){
            System.out.println("El coro semicircular esta ordenado");
        }
        else{
            System.out.println("El coro semicircular NO esta ordenado");
        }
        if(hileras.InformarOrdenando()){
            System.out.println("El coro de hileras esta ordenado");
        }
        else{
            System.out.println("El coro de hileras NO esta ordenado");
        }
        
        System.out.println(semiCirc);
        System.out.println(hileras);
    }
    
}
