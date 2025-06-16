/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Gaston PC
 */
public class Chofer {
    private String nroLicencia;

    
    public Chofer(String nroLicencia){
        this.nroLicencia = nroLicencia;

    }
    
    // set
    public void setNroLicencia( String nroLicencia){
        this.nroLicencia= nroLicencia;
    }
   
    
    // gett
    
    public String getNroLicencia(){
        return nroLicencia;
    }
 

}
