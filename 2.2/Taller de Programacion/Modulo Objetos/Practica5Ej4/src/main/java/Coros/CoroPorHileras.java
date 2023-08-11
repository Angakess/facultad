/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Coros;

import Personas.Corista;
import Personas.Director;

public class CoroPorHileras extends Coro {
    
    private Corista[][] coristas;
    private int hileras;
    private int cantPorHileras;
    private int DimF;
    private int DimL;
    private int DimHileras;
    private int DimHileraActual;

    public CoroPorHileras(Director director, int hileras, int cantPorHileras) {
        super(director);
        this.hileras = hileras;
        this.cantPorHileras = cantPorHileras;
        this.coristas = new Corista[this.cantPorHileras][this.hileras];
        this.DimF = this.cantPorHileras * this.hileras;
        this.DimL = 0;
        this.DimHileras = 0;
        this.DimHileraActual = 0;
    }

    @Override
    public boolean CoroLleno() {
        return (this.DimL == this.DimF);
    }

    @Override
    public void AgregarCorista(Corista corista) {
        if (!this.CoroLleno()){
            this.coristas[this.DimHileraActual][this.DimHileras] = corista;
            this.DimL++;
            if ((this.DimHileraActual+1) == this.cantPorHileras){
                this.DimHileraActual = 0;
                this.DimHileras++;
            }
            else
                this.DimHileraActual++;
        }
    }

    private boolean HileraConMismoTono(int hilera)
    {
        int tono = this.coristas[0][hilera].getTono();
        int idx = 0;
        while(idx < this.cantPorHileras-1 && tono == this.coristas[idx+1][hilera].getTono())
        {
            idx++;
            tono = this.coristas[idx][hilera].getTono();
        }
        return idx == this.cantPorHileras-1;
    }
    
    @Override
    public boolean CoroBienFormado() {
        int tono = this.coristas[0][0].getTono();
        int y = 0;
        while (y < this.hileras-1 && this.HileraConMismoTono(y) && tono > this.coristas[0][y+1].getTono()){
            y++;
            tono = this.coristas[0][y].getTono();
        }
        return y == this.hileras - 1 && this.HileraConMismoTono(y); //Se... hice un desastre, no vas a entender nada. Si necesitas explicación mandá al warap
    }
    
    public String toString()
    {
        String aux = super.toString();
        for (int y = 0; y < this.DimHileras; y++)
        {
            aux += "Hilera N" + y + "\n";
            for (int x = 0; x < this.cantPorHileras; x++)
            {
                aux += this.coristas[x][y].toString() + "\n";
            }
        }
        return aux;
    }
}
