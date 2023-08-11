/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repaso.Ej04;

/**
 *
 * @author andre
 */
public abstract class Coro {
    private String nombreC;
    private Director dir;

    public Coro(String nombreC, Director dir) {
        this.nombreC = nombreC;
        this.dir = dir;
    }

    public Director getDir() {
        return dir;
    }

    public void setDir(Director dir) {
        this.dir = dir;
    }

    public String getNombreC() {
        return nombreC;
    }

    public void setNombreC(String nombreC) {
        this.nombreC = nombreC;
    }
    
    

    @Override
    public String toString() {
        return "nombre del coro= " + nombreC + ", dir= " + dir;
    }
    
}
