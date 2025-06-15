/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author Gaston PC
 */
public class Chofer {
    private String nroLicencia;
    private Categoria categoria;
    
    public Chofer(String nroLicencia, Categoria categoria){
        this.nroLicencia = nroLicencia;
        this.categoria = categoria;
    }
    
    // set
    public void setNroLicencia( String nroLicencia){
        this.nroLicencia= nroLicencia;
    }
    public void setCategoria( Categoria categoria){
        this.categoria= categoria;
    }
    
    // gett
    
    public String getNroLicencia(){
        return nroLicencia;
    }
    public Categoria getCategoria(){
        return categoria;
    }

}
