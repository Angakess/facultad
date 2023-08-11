/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package final_22;

/**
 *
 * @author andre
 */
public class Final_22 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Sub_est se = new Sub_est("aaaaa","abcd",21,"Buenos Aires",250,5,1400);
        Sub_bien sb = new Sub_bien("zzzzzz","fghi",25,10);
        
        Bien b1 = new Bien("qweqweqwe",10,100);
        Bien b2 = new Bien("asdasdasda",4,90);
        Bien b3 = new Bien("zxczxczxczxc",2,200);
        
        sb.agregarBien(b1);
        sb.agregarBien(b2);
        sb.agregarBien(b3);
        
        System.out.println(se);
        System.out.println("----------------------------------------");
        System.out.println(sb);
    }
    
}
