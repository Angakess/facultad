/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema1;

//Paso 1. importar la funcionalidad para generar datos aleatorios

import PaqueteLectura.GeneradorAleatorio;
import PaqueteLectura.Lector;


public class Ej03Matrices {
    public static void main(String[] args) {
	    //Paso 2. iniciar el generador aleatorio     
	 int[][] matriz = new int[5][5];
         int i,j;
         for(i = 0;i<5;i++){
             for(j = 0;j<5;j++){
                 matriz[i][j] = GeneradorAleatorio.generarInt(31);
             }
         }
        //Paso 3. definir la matriz de enteros de 5x5 e iniciarla con nros. aleatorios 
        //Paso 4. mostrar el contenido de la matriz en consola
        for(i = 0;i<5;i++){
             for(j = 0;j<5;j++){
                 System.out.println("La posicion "+i+","+j+" tiene "+matriz[i][j]);
             }
             System.out.println("----------------------------------");
         }
        //Paso 5. calcular e informar la suma de los elementos de la fila 1
        int sum = 0;
        for (j=0;j<5;j++){
           sum = sum + matriz[1][j]; 
        }
        System.out.println("Total de la fila 1: "+sum);
        //Paso 6. generar un vector de 5 posiciones donde cada posición j contiene la suma de los elementos de la columna j de la matriz. 
        //        Luego, imprima el vector.
        int[] vector = new int[5];
        int total;
        for (j=0;j<5;j++){
            total = 0;
            for(i=0;i<5;i++){
                total = total + matriz[i][j];
            }
            vector[j]=total;
        }
        for (j=0;j<5;j++){
            System.out.println(vector[j]);
        }
        //Paso 7. lea un valor entero e indique si se encuentra o no en la matriz. En caso de encontrarse indique su ubicación (fila y columna)
        //   y en caso contrario imprima "No se encontró el elemento".
        System.out.println("Ingrese un numero para buscar: ");
        int x = Lector.leerInt();
        boolean exito = false;
        int col = 0;
        int fil = 0;
        for(i=0;i<5;i++){
            for(j=0;j<5;j++){
                if(matriz[i][j] == x){
                    exito=true;
                    fil = i;
                    col = j;
                }
            }
        }
        if(exito){
            System.out.println("Se encontro el numero "+x+" en la posicion"+fil+","+col);
        }
        else{
            System.out.println("No se encontro el numero "+x);
        }
    }
}
