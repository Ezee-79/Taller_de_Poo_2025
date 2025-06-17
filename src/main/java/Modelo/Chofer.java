/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
 
 package Modelo;
 import java.util.ArrayList;
/**
 *
 * @author Gaston PC
 */
public class Chofer extends Persona {
    private String nroLicencia;
    private Viaje viaje;
    private ArrayList <ChoferCategoria> choferCategorias;

    
    public Chofer(String nroLicencia, long dni, String nombre, String apellido, Viaje viaje){
        super(dni, nombre, apellido);
        this.nroLicencia = nroLicencia;
        this.viaje = viaje;
        this.choferCategorias = new ArrayList<ChoferCategoria>();
    }
    
    // set
    public void setNroLicencia(String nroLicencia){
        this.nroLicencia= nroLicencia;
    }

    public void setViaje (Viaje viaje) {
        this.viaje = viaje;
    }

    public void setChoferCategoria(ArrayList <ChoferCategoria> choferCategorias) {
        this.choferCategorias = new ArrayList<ChoferCategoria>();
    }
   
    
    // get
    
    public String getNroLicencia(){
        return nroLicencia;
    }

    public Viaje getViaje(){
        return viaje;
    }

    public ArrayList <ChoferCategoria> getChoferCategorias(){
        return choferCategorias;
    }
 

}