/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema3;

/**
 *
 * @author andre
 */
public class Autor {
    private String nombre;
    private String bio;
    private String origen;
    
    public Autor(String unNombre, String unaBio, String unOrigen){
        nombre = unNombre;
        bio = unaBio;
        origen = unOrigen;
    }
    public Autor(){
        
    }
    
    public String getNombre(){
        return nombre;
    }
    public String getBio(){
        return bio;
    }
    public String getOrigen(){
        return origen;
    }
    
    public void setNombre(String unNombre){
        nombre = unNombre;
    }
    public void setBio(String unaBio){
        bio = unaBio;
    }
    public void setOrigen(String unOrigen){
        origen = unOrigen;
    }
    
    @Override
    public String toString(){
        String aux = "Nombre: "+nombre+" Biografia: "+bio+" Origen: "+origen;
        return aux;
    }
    
}
