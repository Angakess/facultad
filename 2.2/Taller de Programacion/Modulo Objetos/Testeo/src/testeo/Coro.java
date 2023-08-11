/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testeo;

/**
 *
 * @author alumnos
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
    
    public abstract void agregarCorista(Corista corista);
    public abstract boolean coroLleno();
    public abstract boolean coroBienFormado();
    
    @Override
    public String toString(){
        return "Coro | Director: " + director.toString();
    }
    
    
    
}
