/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package Main;

import Coros.CoroPorHileras;
import Coros.CoroSemicircular;
import Personas.Corista;
import Personas.Director;

/**
 *
 * @author bonac
 */
public class main {

    public static void main(String[] args) {
        /*Director dir = new Director("Sarasa", 10230123, 10, 1);
        CoroSemicircular coro = new CoroSemicircular(dir, 3);
        coro.AgregarCorista(new Corista("Sarasa1", 1231239, 123, 10));
        coro.AgregarCorista(new Corista("Sarasa1", 1231239, 123, 7));
        coro.AgregarCorista(new Corista("Sarasa1", 1231239, 123, 3));
        System.out.println(coro.toString());
        System.out.println(coro.CoroBienFormado());*/
        
        Director dir = new Director("Sarasa", 10230123, 10, 1);
        CoroPorHileras coroHileras = new CoroPorHileras(dir, 2, 2);
        coroHileras.AgregarCorista(new Corista("Sarasa1", 1231239, 123, 10));
        coroHileras.AgregarCorista(new Corista("Sarasa12", 1231239, 123, 10));
        coroHileras.AgregarCorista(new Corista("Sarasa2", 1231239, 123, 7));
        coroHileras.AgregarCorista(new Corista("Sarasa23", 1231239, 123, 7));
        System.out.println(coroHileras.toString());
        System.out.println(coroHileras.CoroBienFormado());
    }
}
