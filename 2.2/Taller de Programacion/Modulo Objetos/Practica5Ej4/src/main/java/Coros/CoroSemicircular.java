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
public class CoroSemicircular extends Coro {
    
    private Corista[] coristas;
    private int DimF;
    private int DimL;

    public CoroSemicircular(Director dir, int dimF) {
        super(dir);
        this.DimF = dimF;
        this.DimL = 0;
        this.coristas = new Corista[this.DimF];
    }
    
    @Override
    public void AgregarCorista(Corista corista) {
        if (!this.CoroLleno())
        {
            this.coristas[this.DimL] = corista;
            this.DimL++;
        }
    }
    
    @Override
    public boolean CoroLleno() {
        return (this.DimL == this.DimF);
    }
    
    @Override
    public boolean CoroBienFormado() {
        int tonoMaximo = this.coristas[0].getTono();
        int idx = 0;
        while(idx < this.DimL-1 && tonoMaximo > this.coristas[idx+1].getTono())
        {
            idx++;
            tonoMaximo = this.coristas[idx].getTono();
        }
        return idx == this.DimL-1;
    }
    
    public String toString()
    {
        String aux = super.toString();
        for (int i = 0; i < this.DimL; i++)
        {
            aux += this.coristas[i].toString() + "\n";
        }
        return aux;
    }
}
