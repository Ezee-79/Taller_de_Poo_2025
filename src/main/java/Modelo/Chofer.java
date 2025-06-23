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
    private ArrayList<Viaje> viajesProgramados = new ArrayList<Viaje>();
    private ArrayList<Viaje> viajesFinalizados = new ArrayList<Viaje>();

    public Chofer() {
    }

    public Chofer(String nroLicencia, long dni, String nombre, String apellido) {
        super(dni, nombre, apellido);
        this.nroLicencia = nroLicencia;
        this.estaDisponible = true;
    }

    public String getNroLicencia() {
        return nroLicencia;
    }

    public void setNroLicencia(String nroLicencia) {
        this.nroLicencia = nroLicencia;
    }

    public boolean isEstaDisponible() {
        return estaDisponible;
    }

    public void setEstaDisponible(boolean estaDisponible) {
        this.estaDisponible = estaDisponible;
    }

    public ArrayList<Viaje> getViajesProgramados() {
        return viajesProgramados;
    }

    public void setViajesProgramados(ArrayList<Viaje> viajesProgramados) {
        this.viajesProgramados = viajesProgramados;
    }

    public ArrayList<Viaje> getViajesFinalizados() {
        return viajesFinalizados;
    }

    public void setViajesFinalizados(ArrayList<Viaje> viajesFinalizados) {
        this.viajesFinalizados = viajesFinalizados;
    }

    public void agregarViaje(Viaje viaje) {
        viajesFinalizados.add(viaje);
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