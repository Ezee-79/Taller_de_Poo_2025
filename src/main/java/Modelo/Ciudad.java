package Modelo;
import java.util.ArrayList;

public class Ciudad {
    private String nombre;
    private EnumProvincia provincia;
    private ArrayList<Viaje> viajeOrigen;
    private ArrayList<Viaje> viajeDestino;

    public Ciudad() {
    }

    public Ciudad(String nombre, EnumProvincia provincia, ArrayList<Viaje> viajeOrigen, ArrayList<Viaje> viajeDestino) {
        this.nombre = nombre;
        this.provincia = provincia;
        this.viajeOrigen = new ArrayList<Viaje>();
        this.viajeDestino = new ArrayList<Viaje>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public EnumProvincia getProvincia() {
        return provincia;
    }

    public void setProvincia(EnumProvincia provincia) {
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