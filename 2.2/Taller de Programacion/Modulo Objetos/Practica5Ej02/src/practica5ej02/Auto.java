/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica5ej02;

/**
 *
 * @author andre
 */
public class Auto {
    private String dueño;
    private String pat;

    public Auto(String dueño, String pat) {
        this.dueño = dueño;
        this.pat = pat;
    }

    public String getDueño() {
        return dueño;
    }

    public void setDueño(String dueño) {
        this.dueño = dueño;
    }

    public String getPat() {
        return pat;
    }

    public void setPat(String pat) {
        this.pat = pat;
    }

    @Override
    public String toString() {
        return "Auto{" + "due\u00f1o= " + dueño + ", pat= " + pat + '}';
    }
    
    
    
}
