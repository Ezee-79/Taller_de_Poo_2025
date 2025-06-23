package Modelo;

import java.util.ArrayList;

public abstract class Vehiculo {
    private String patente;
    private int capacidad;
    private boolean estaDisponible;
    private ArrayList<Viaje> viajesProgramados = new ArrayList<Viaje>();
    private ArrayList<Viaje> viajesFinalizados = new ArrayList<Viaje>();

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
}
