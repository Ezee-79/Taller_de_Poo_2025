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
    private boolean estaDisponible;
    private ArrayList<Viaje> viajes = new ArrayList<Viaje>();

    public Chofer() {
    }

    public Chofer(String nroLicencia, long dni, String nombre, String apellido) {
        super(dni, nombre, apellido);
        this.nroLicencia = nroLicencia;
        this.estaDisponible = true;
    }

    // set
    public void setNroLicencia(String nroLicencia) {
        this.nroLicencia = nroLicencia;
    }

    public void setViajes(ArrayList<Viaje> viajes) {
        this.viajes = viajes;
    }

    // get
    public String getNroLicencia() {
        return nroLicencia;
    }

    public ArrayList<Viaje> getViajes() {
        return viajes;
    }

    public boolean isEstaDisponible() {
        return estaDisponible;
    }

    public void setEstaDisponible(boolean estaDisponible) {
        this.estaDisponible = estaDisponible;
    }

    // toString
    @Override
    public String toString() {
        String disponible = (estaDisponible) ? "Si" : "No";
        return "CHOFER{\n"
                + " Nombre: " + getNombre() + ",\n"
                + " Apellido: " + getApellido() + ",\n"
                + " DNI: " + getDni() + ",\n"
                + " Numero de Licencia: " + nroLicencia + ",\n"
                + " Disponible: " + disponible + "}";
    }
}