package Modelo;

import java.util.ArrayList;

public abstract class Vehiculo {
    private String patente;
    private int capacidad;
    private boolean estaDisponible;
    private ArrayList<Viaje> viajes = new ArrayList<Viaje>();

    // CONSTRUCTORES.
    public Vehiculo() {
    }

    public Vehiculo(String patente, int capacidad) {
        this.patente = patente;
        this.capacidad = capacidad;
        this.estaDisponible = true;
    }

    // GETTERS & SETTERS.
    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public boolean isEstaDisponible() {
        return estaDisponible;
    }

    public void setEstaDisponible(boolean estaDisponible) {
        this.estaDisponible = estaDisponible;
    }

    public ArrayList<Viaje> getViajes() {
        return viajes;
    }

    public void setViajes(ArrayList<Viaje> viajes) {
        this.viajes = viajes;
    }
}
