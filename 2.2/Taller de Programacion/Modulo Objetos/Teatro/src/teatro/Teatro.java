/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teatro;

/**
 *
 * @author andre
 */
public class Teatro {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Funcion func = new Funcion("Batman",23,20,5,10);
        
        func.ocuparButacaEInformarPrecio(1, 3);
        func.ocuparButacaEInformarPrecio(3, 4);
        func.ocuparButacaEInformarPrecio(5, 1);
        func.ocuparButacaEInformarPrecio(3, 7);
        func.ocuparButacaEInformarPrecio(5, 10);
        System.out.println(func);
        
        System.out.println("-------------------------------------------------");
        
        func.desocuparFila(5);
        System.out.println(func);
        
        System.out.println("-------------------------------------------------");
        
        func.desocuparFila(3);
        System.out.println(func);
    }
    
}
