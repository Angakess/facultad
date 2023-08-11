
package tema1;

//Paso 1: Importar la funcionalidad para lectura de datos
import PaqueteLectura.Lector;



public class Ej02Jugadores {

  
    public static void main(String[] args) {
        //Paso 2: Declarar la variable vector de double 
        double[] edades;
        //Paso 3: Crear el vector para 15 double 
        edades = new double [15];
        //Paso 4: Declarar indice y variables auxiliares a usar
        int i,cant;
        double sum = 0;
         //Paso 6: Ingresar 15 numeros (altura), cargarlos en el vector, ir calculando la suma de alturas
        for (i=0;i<15;i++){
            System.out.println("Ingrese la altura: ");
            edades[i] = Lector.leerDouble();
            sum = sum + edades[i];
        }
        //Paso 7: Calcular el promedio de alturas, informarlo
        System.out.println("La altura promedio es: " + (sum/15));
        //Paso 8: Recorrer el vector calculando lo pedido (cant. alturas que están por encima del promedio)
        cant = 0;
        for (i=0;i<15;i++){
            if(edades[i] > (sum / 15)){
                cant = cant + 1;
            }
        }
        //Paso 9: Informar la cantidad.
        System.out.println("Hay "+cant+" jugadores con altura mayor al promedio");
    }
    
}
