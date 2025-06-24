/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Modelo;

import java.util.ArrayList;

/**
 * Clase para la Chofer extendida de la clase {@link Persona}.
 * 
 * Cada uno con su numero de licencia, disponibilidad y lista de viajes asignados.
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
     * @param nroLicencia     Numero de licencia del chofer.
     * @param dni             Numero de dni del chofer, extendido de {@link Persona}.
     * @param nombre          Nombre del chofer, extendido de {@link Persona}.
     * @param apellido        Apellido del chofer, extendido de {@link Persona}.
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
     * Retorna la disponiblidad del chofer para un viaje.
     * 
     * @return {@code true} si está disponible, {@code false} en caso contrario.
     */
    public boolean isEstaDisponible() {
        return estaDisponible;
    }

    /**
     * Define si un chofer esta ocupado o no, para conducir un viaje.
     * 
     * @param estaDisponible valor booleano de disponibilidad. {@code true} si lo esta, sino {@code false}.
     */
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