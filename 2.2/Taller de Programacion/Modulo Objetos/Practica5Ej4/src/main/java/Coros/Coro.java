/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Coros;

import Personas.Corista;
import Personas.Director;

/**
 *
 * @author bonac
 */
public abstract class Coro {
    
    private Director director;

    public Coro(Director director) {
        this.director = director;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }
    
    public abstract boolean CoroLleno();
    public abstract void AgregarCorista(Corista corista);
    public abstract boolean CoroBienFormado();
    
    @Override
    public String toString(){
        return "Coro | " + this.director.toString() + "\nCoro Lleno: " + this.CoroLleno() + " | Coro Bien Formado: " + this.CoroBienFormado() + "\nCoristas: \n";
    }
}
