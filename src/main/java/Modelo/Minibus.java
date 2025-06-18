package Modelo;

/* Enzo */
public class Minibus extends Vehiculo {
    private boolean tieneBodega;
    private boolean tieneAire;

    // CONSTRUCTORES.
    public Minibus() {
    }

    public Minibus(String patente, int capacidad, boolean tieneBodega, boolean tieneAire) {
        super(patente, capacidad);
        this.tieneBodega = tieneBodega;
        this.tieneAire = tieneAire;
    }

    // SETTERS & GETTERS
    public boolean isTieneBodega() {
        return tieneBodega;
    }

    public void setTieneBodega(boolean tieneBodega) {
        this.tieneBodega = tieneBodega;
    }

    public boolean isTieneAire() {
        return tieneAire;
    }

    public void setTieneAire(boolean tieneAire) {
        this.tieneAire = tieneAire;
    }

    // TOSTRING.
    @Override
    public String toString() {
        String bodega = (tieneBodega) ? "Si" : "No";
        String aire = (tieneAire) ? "Si" : "No";

        return "MINIBUS{\n"
                + " Patente: " + getPatente() + ",\n"
                + " Capacidad: " + getCapacidad() + ",\n"
                + " Bodega: " + bodega + ",\n"
                + " Aire Acondicionado: " + aire + "}";
    }
}
