/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema3;

import PaqueteLectura.GeneradorAleatorio;
import PaqueteLectura.Lector;

/**
 *
 * @author andre
 */
public class CrearEstante {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Estante estante1 = new Estante();
        Libro l = new Libro();
        GeneradorAleatorio.iniciar();
        System.out.println("Ingrese un titulo: ");
        l.setTitulo(Lector.leerString());
        while(!(l.getTitulo().equals("ZZZ"))&&
             (estante1.getDimL()<estante1.getDF())){
                l.setEditorial(GeneradorAleatorio.generarString(5));
                l.setAñoEdicion(GeneradorAleatorio.generarInt(50)+1970);
                l.setPrimerAutor((GeneradorAleatorio.generarString(10)),
                    (GeneradorAleatorio.generarString(10)),
                    (GeneradorAleatorio.generarString(10)));
                l.setISBN(GeneradorAleatorio.generarString(3));
                l.setPrecio(GeneradorAleatorio.generarDouble(500)+1);
                
                estante1.AgregarLibro(l);
                System.out.println("Ingrese un titulo: ");
                
                l = new Libro();
                l.setTitulo(Lector.leerString());
        }
        for(int i=0; i<estante1.getDimL();i++){
            System.out.println(estante1.getVector()[i].toString());
        }
        System.out.println("-----------------------------------------------------------");
        System.out.println("Hay "+estante1.InformarAlmacenados()+" libros en el estante");
        if(estante1.InformarLleno()){
            System.out.println("El estante esta lleno");
        }
        System.out.println("Ingrese un titulo para buscar: ");
        String tit = Lector.leerString();
        
        if(estante1.DevolverTitulo(tit) != null){
            System.out.println(estante1.DevolverTitulo(tit).toString());
            System.out.println(estante1.DevolverTitulo(tit).getPrimerAutor().toString());
        }
        else{
            System.out.println("No se encontro el titulo buscado");
        }
        
        
    }
    
}
