/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema2;
import PaqueteLectura.GeneradorAleatorio;

/**
 *
 * @author andre
 */
public class CrearVector {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int DF = 15;
        Persona vector[] = new Persona[DF];
        GeneradorAleatorio.iniciar();
        int aux = GeneradorAleatorio.generarInt(10);
        int dimL = 0;
        
        while((aux != 0)&&(dimL < DF)){
            Persona x = new Persona(GeneradorAleatorio.generarString(6),GeneradorAleatorio.generarInt(200),aux);
            vector[dimL] = x;
            System.out.println(vector[dimL].toString());
            dimL++;
            aux = GeneradorAleatorio.generarInt(10);
        }
        int cant = 0;
        int cant1 = 0;
        Persona pMin = new Persona();
        pMin.setDNI(9999);
        for(int i=0;i<dimL;i++){
            cant1++;
            if(vector[i].getEdad()>65){
                cant++;
            }
            if(vector[i].getDNI()<pMin.getDNI()){
                pMin = vector[i];
            }
        }
        System.out.println("-------------------------------------------------");
        System.out.println("total: "+cant1);
        System.out.println("Hay "+cant+" personas mayores de 65 años");
        System.out.println(pMin.toString());
        
    }
    
}
