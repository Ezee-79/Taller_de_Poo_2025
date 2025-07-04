/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Modelo;

import java.util.ArrayList;

/**
 * Clase para la clase Chofer extendida de la clase {@link Persona}.
 * 
 * Cada uno con su numero de licencia, disponibilidad y lista de viajes
 * asignados.
 * 
 * @author Gaston.
 * @author Denis.
 * @author Enzo.
 * 
 */
public class Chofer extends Persona {
    private String nroLicencia;
    private boolean estaDisponible;
    private ArrayList<Viaje> viajesProgramados = new ArrayList<Viaje>();
    private ArrayList<Viaje> viajesFinalizados = new ArrayList<Viaje>();

    /**
     * Constructor por defecto.
     */
    public Chofer() {
    }

    /**
     * Constructor con parametros.
     * 
     * @param nroLicencia Numero de licencia del chofer.
     * @param dni         Numero de dni del chofer, extendido de {@link Persona}.
     * @param nombre      Nombre del chofer, extendido de {@link Persona}.
     * @param apellido    Apellido del chofer, extendido de {@link Persona}.
     */
    public Chofer(String nroLicencia, long dni, String nombre, String apellido) {
        super(dni, nombre, apellido);
        this.nroLicencia = nroLicencia;
        this.estaDisponible = true;
    }

    /**
     * Establece el numero de licencia del chofer
     * 
     * @param nroLicencia El numero de licencia.
     */
    public void setNroLicencia(String nroLicencia) {
        this.nroLicencia = nroLicencia;
    }

    /**
     * retorna el numero de licencia del chofer.
     * 
     * @return el numero de licencia.
     */

    public String getNroLicencia() {
        return nroLicencia;
    }

    /**
     * Asigna una lista de viajes correspondientes al chofer.
     * 
     * @param viajesProgramados lista de viajes programados.
     */
    public ArrayList<Viaje> getViajesProgramados() {
        return viajesProgramados;
    }

    /**
     * Retorna la lista de viajes programados del chofer.
     * 
     * @return lista de viajes programados que se le asigna al chofer.
     */
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
        viajesProgramados.add(viaje);
    }

    // toString

    /**
     * Representacion de los datos impresos del chofer.
     * 
     * @return cadena de datos del chofer.
     */

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