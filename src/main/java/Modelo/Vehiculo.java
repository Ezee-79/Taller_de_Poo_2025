package Modelo;


public abstract class Vehiculo {
    private String patente;
    private int capacidad;

    public Vehiculo() {
    }

    public Vehiculo(String patente, int capacidad) {
        this.patente = patente;
        this.capacidad = capacidad;
    }

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
}
