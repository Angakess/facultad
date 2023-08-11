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
public class Sub_bien extends Subsidio{
    private int cantN;
    private int dimL;
    private Bien[] vector;
    
    public Sub_bien(String investigador, String plan, int fecha, int cantN) {
        super(investigador, plan, fecha);
        this.cantN = cantN;
        this.dimL = 0;
        this.vector = new Bien[cantN];
    }
    
    public void agregarBien(Bien unBien){
        if (this.dimL < this.cantN){
            this.vector[this.dimL] = unBien;
            this.dimL++;
        }
    }
    
    public float calcularMontoTotal(){
        float total = 0;
        for (int i=0; i < this.dimL; i++){
            total = total + (this.vector[i].getCant() * this.vector[i].getCosto());
        }
        return total;
    }
    
    @Override
    public String toString(){
        String aux = "";
        for (int i=0; i < this.dimL; i++){
            aux = (aux+"Descripcion del bien"+i+" : "+this.vector[i].getDesc()+"    | ");
        }
        return (super.toString()+"  || "+aux);
    }
}
