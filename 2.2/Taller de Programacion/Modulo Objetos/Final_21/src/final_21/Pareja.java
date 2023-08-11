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
public class Pareja {
    private Participante uno;
    private Participante dos;
    private String estilo;

    public Pareja(int unoDni, String unoNombre, int unoEdad,int dosDni,
                String dosNombre,int dosEdad, String estilo) {
        
        this.uno = new Participante(unoDni,unoNombre,unoEdad);
        this.dos = new Participante(dosDni,dosNombre,dosEdad);
        this.estilo = estilo;
    }

    public Participante getUno() {
        return uno;
    }

    public Participante getDos() {
        return dos;
    }
    public int calcularDif(){
        if(this.uno.getEdad() > this.dos.getEdad()){
            return (this.uno.getEdad() - this.dos.getEdad());
        }
        else{
            return (this.dos.getEdad() - this.uno.getEdad());
        }
    }
}
