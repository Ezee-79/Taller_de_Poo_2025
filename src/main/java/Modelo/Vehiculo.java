package Modelo;
/* Enzo */
public abstract class Vehiculo {
    private String patente;
    private int capacidad;

    //CONSTRUCTORES
    public Vehiculo() {
    }

    public Vehiculo(String patente, int capacidad) {
        this.patente = patente;
        this.capacidad = capacidad;
    }

    //GETTERS & SETTERS.
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
