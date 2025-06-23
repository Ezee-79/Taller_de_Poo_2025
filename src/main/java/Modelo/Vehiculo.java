package Modelo;

import java.util.ArrayList;

/**
 * Clase abstracta que representa un vehículo que puede ser utilizado en uno o más viajes.
 * Contiene información sobre la patente, capacidad, disponibilidad y los viajes asociados.
 * 
 * Esta clase sirve como base para distintos tipos de vehículos.
 * 
 * @author Gaston. 
 * @author Denis.
 * @author Enzo.
 */

public abstract class Vehiculo {
    private String patente;
    private int capacidad;
    private boolean estaDisponible;
    private ArrayList<Viaje> viajes = new ArrayList<Viaje>();

    /**
     * Constructor vacío de la clase Vehiculo.
     * Inicializa una instancia sin asignar valores a los atributos.
     */
    public Vehiculo() {
    }

     /**
     * Constructor que permite inicializar un vehículo con su patente y capacidad.
     * El vehículo se marca como disponible por defecto.
     *
     * @param patente la patente del vehículo.
     * @param capacidad la cantidad máxima de pasajeros que puede transportar el vehículo.
     */
    public Vehiculo(String patente, int capacidad) {
        this.patente = patente;
        this.capacidad = capacidad;
        this.estaDisponible = true;
    }

    /**
     * Obtiene la patente del vehículo.
     *
     * @return la patente del vehículo.
     */
    public String getPatente() {
        return patente;
    }

    /**
     * Establece la patente del vehículo.
     *
     * @param patente nueva patente del vehículo.
     */
    public void setPatente(String patente) {
        this.patente = patente;
    }

    /**
     * Obtiene la capacidad del vehículo.
     *
     * @return la capacidad del vehículo.
     */
    public int getCapacidad() {
        return capacidad;
    }

    /**
     * Establece la capacidad del vehículo.
     *
     * @param capacidad nueva capacidad máxima de pasajeros.
     */
    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    /**
     * Indica si el vehículo está disponible para realizar viajes.
     *
     * @return {@code true} si el vehículo está disponible, {@code false} en caso contrario.
     */
    public boolean isEstaDisponible() {
        return estaDisponible;
    }

    /**
     * Define la disponibilidad del vehículo.
     *
     * @param estaDisponible {@code true} si el vehículo está disponible, {@code false} si no lo está.
     */
    public void setEstaDisponible(boolean estaDisponible) {
        this.estaDisponible = estaDisponible;
    }

    /**
     * Obtiene la lista de viajes asignados al vehículo.
     *
     * @return una lista de objetos Viaje.
     */
    public ArrayList<Viaje> getViajes() {
        return viajes;
    }

    /**
     * Establece la lista de viajes del vehículo.
     *
     * @param viajes una nueva lista de objetos Viaje asignados al vehículo.
     */
    public void setViajes(ArrayList<Viaje> viajes) {
        this.viajes = viajes;
    }
}
