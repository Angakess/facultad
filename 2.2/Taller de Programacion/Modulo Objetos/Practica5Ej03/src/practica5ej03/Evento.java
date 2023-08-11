/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica5ej03;

/**
 *
 * @author andre
 */
public class Evento extends Recital {
    private String motivo;
    private String contratante;
    private String dia;

    public Evento(String motivo, String contratante, String dia, String banda, int cantTemas) {
        super(banda, cantTemas);
        this.motivo = motivo;
        this.contratante = contratante;
        this.dia = dia;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getContratante() {
        return contratante;
    }

    public void setContratante(String contratante) {
        this.contratante = contratante;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }
    
   
    @Override
    public String actuar(){
        String aux = "";
        switch (motivo) {
            case "a beneficio" -> aux = "Recuerden colaborar con..."+contratante;
            case "show de TV" -> aux = "Saludo amigos televidente";
            case "show privado" -> aux = "Un felix cumpleaños para..."+contratante;
            default -> {
            }
        }
        return (aux + super.actuar());
    }
    
    @Override
    public double calcularCosto(){
        switch (motivo) {
            case "a beneficio" -> {
                return 0;
            }
            case "show de TV" -> {
                return 50000;
            }
            case "show privado" -> {
                return 150000;
            }
            default -> {
                System.out.println("Error: El evento no tiene un motivo.");
                return -1;
            }
        }
    }
}
