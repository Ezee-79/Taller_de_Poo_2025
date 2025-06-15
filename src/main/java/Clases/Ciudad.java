package Clases;

import java.util.ArrayList;


public class Ciudad {
    private String nombre;
    private Provincia provincia;
    private ArrayList<Viaje> viajeOrigen;
    private ArrayList<Viaje> viajeDestino;

    public Ciudad() {
    }

    public Ciudad(String nombre, Provincia provincia, ArrayList<Viaje> viajeOrigen, ArrayList<Viaje> viajeDestino) {
        this.nombre = nombre;
        this.provincia = provincia;
        this.viajeOrigen = new ArrayList<Viaje>();
        this.viajeDestino = new ArrayList<Viaje>();

    public Ciudad(String nombre, Provincia provincia) {
        this.nombre = nombre;
        this.provincia = provincia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Provincia getProvincia() {
        return provincia;
    }

    public void setProvincia(Provincia provincia) {
        this.provincia = provincia;
    }

    public ArrayList<Viaje> getViajeOrigen() {
        return viajeOrigen;
    }

    public void setViajeOrigen(ArrayList<Viaje> viajeOrigen) {
        this.viajeOrigen = viajeOrigen;
    }

    public ArrayList<Viaje> getViajeDestino() {
        return viajeDestino;
    }

    public void setViajeDestino(ArrayList<Viaje> viajeDestino) {
        this.viajeDestino = viajeDestino;
    }
}
