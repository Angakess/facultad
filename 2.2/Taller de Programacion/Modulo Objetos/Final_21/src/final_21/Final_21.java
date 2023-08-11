/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package final_21;

        
/**
 *
 * @author andre
 */
public class Final_21 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Concurso conc = new Concurso (10);
        
        Pareja par1 = new Pareja(111,"Abc",32,222,"Dfg",23,"salsa");
        conc.agregarPareja(par1);
        Pareja par2 = new Pareja(333,"qweqwr",43,444,"hfghf",38,"tango");
        conc.agregarPareja(par2);
        Pareja par3 = new Pareja(555,"zzzzzz",55,222,"wwwwww",53,"pop");
        conc.agregarPareja(par3);
        Pareja par4 = new Pareja(666,"erererer",21,777,"cvcvcvcvc",22,"salsa");
        conc.agregarPareja(par4);
        
        System.out.println("Nombre del primer participante de la pareja con mas diferencia de edad: "+ conc.difMax().getUno().getNombre());
        System.out.println("Nombre del segundo participante de la pareja con mas diferencia de edad: "+ conc.difMax().getDos().getNombre());
    }
    
}
